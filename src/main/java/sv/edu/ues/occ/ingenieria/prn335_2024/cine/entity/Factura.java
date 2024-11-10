package sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "factura", schema = "public")
public class Factura {
    @Id
    @Column(name = "id_factura", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<FacturaDetalleSala> facturaDetalleSalas;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<FacturaDetalleProducto> facturaDetalleProductoList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<Pago> pagoList;

    @Size(max = 255)
    @Column(name = "cliente")
    private String cliente;

    @Size(max = 155)
    @Column(name = "dui", length = 155)
    private String dui;

    @Column(name = "fecha")
    private OffsetDateTime fecha;

    @Lob
    @Column(name = "comentarios")
    private String comentarios;

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long id) {
        this.idFactura = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public OffsetDateTime getFecha() {
        return fecha;
    }

    public void setFecha(OffsetDateTime fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }


    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    public List<FacturaDetalleSala> getFacturaDetalleSalas() {
        return facturaDetalleSalas;
    }

    public void setFacturaDetalleSalas(List<FacturaDetalleSala> facturaDetalleSalas) {
        this.facturaDetalleSalas = facturaDetalleSalas;
    }

    public List<FacturaDetalleProducto> getFacturaDetalleProductoList() {
        return facturaDetalleProductoList;
    }

    public void setFacturaDetalleProductoList(List<FacturaDetalleProducto> facturaDetalleProductoList) {
        this.facturaDetalleProductoList = facturaDetalleProductoList;
    }
}