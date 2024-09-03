package sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity;
//losiento
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_sala")
public class TipoSala {
    @Id
    @Column(name = "id_tipo_sala")
    protected Integer idTipoSala;
    @Column(name = "nombre", length = 155)
    protected String nombre;
    @Column(name = "activo")
    protected boolean activo;
    @Column(name = "comentarios")
    protected String comentarios;
    @Column(name = "expresion_regular")
    protected String expresionRegular;

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
    