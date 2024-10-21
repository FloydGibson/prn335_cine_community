package sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tipo_sala")
public class TipoSala {
    @Id
    @Column(name = "id_tipo_sala", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idTipoSala;

    @Pattern(regexp = "//d/d/d/d/d/d/d/d/ -/d/")
    @NotBlank(message = "Ingrese un nombre valido")
    @Size(min=3, max = 155)
    @Column(name = "nombre", length = 155)
    protected String nombre;
    @Column(name = "activo")
    protected boolean activo;
    @Column(name = "comentarios")
    protected String comentarios;
    @Column(name = "expresion_regular")
    protected String expresionRegular;

    public TipoSala() {
    }

    public TipoSala(Integer idTipoSala) {
        this.idTipoSala = idTipoSala;
    }

    public void setIdTipoSala(Integer idTipoSala) {
        this.idTipoSala = idTipoSala;
    }

    public Integer getIdTipoSala() {
        return idTipoSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }
}
    