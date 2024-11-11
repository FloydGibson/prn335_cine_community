package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstracBasicFrm<T> implements Serializable {
    protected T registro;
    protected ESTADO_CRUD estado;

    protected abstract Object getId(T object);

    protected abstract AbstractDataPersistence<T> getDataBean();

    protected abstract FacesContext facesContext();

    protected abstract T createNewRegistro();


    List<T> registros;

    @PostConstruct //Solo lo puedo usar una vez por clase
    public void init() {
        estado = ESTADO_CRUD.NINGUNO;
        registros = getDataBean().findRange(0, 10000000);
    }

    public void btnSeleccionarRegistroHandler(final Integer idTipo) {
        if (idTipo != null) {
            this.registro = this.registros.stream()
                    .filter(r -> idTipo.equals(getId(r)))
                    .findFirst()
                    .orElse(null);
            this.estado= ESTADO_CRUD.MODIFICAR;
            return;
        }
        this.registro = null;
    }

    public void btnCancelarHandler( ActionEvent actionEvent) {
        this.estado= ESTADO_CRUD.NINGUNO;
        this.registro = null;
    }

    public Integer getSeleccionado() {
        if (registro == null) {
            return null;
        }
        return (Integer) getId(registro);
    }

    public void setSeleccionado(Integer seleccionado) {
        this.registro = this.registros.stream().filter(r -> getId(r) == seleccionado).collect(Collectors.toList()).getFirst();
        if(this.registro != null) {
            this.estado= ESTADO_CRUD.MODIFICAR;
        }
    }

    public void btnNuevoHandler(ActionEvent actionEvent) {
        this.registro = createNewRegistro();
        this.estado = ESTADO_CRUD.CREAR;
    }

    public void btnGuardarHandler(ActionEvent actionEvent) {
        this.getDataBean().create(registro);
        this.registro= null;
        this.registros = getDataBean().findRange(0,1000000);
    }

    public ESTADO_CRUD getEstado() {
        return estado;
    }

    public void btnModificarHandler(ActionEvent actionEvent) {
        FacesMessage mensaje = new FacesMessage();
        T actualizado = getDataBean().update(registro);
        if(actualizado!=null){
            this.registro = null;
            this.estado= ESTADO_CRUD.NINGUNO;
            mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
            mensaje.setSummary("Registro modificado con éxito");
        }else{
            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
            mensaje.setSummary("No se pudo guardar el registro, revise sus datos");
        }
        facesContext().addMessage(null, mensaje);

    }

    public void btnEliminarHandler(ActionEvent actionEvent) {
        FacesMessage mensaje = new FacesMessage();
        getDataBean().delete(registro);
        mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
        mensaje.setSummary("Registro eliminado con exito");
        facesContext().addMessage(null, mensaje);
        this.registro = null;
        this.estado = ESTADO_CRUD.NINGUNO;
        this.registros = getDataBean().findRange(0,1000000);
    }

    public T getRegistro() {
        return registro;
    }

    public void setRegistro(T registro) {
        this.registro = registro;
    }

    public List<T> getRegistros() {
        return registros;
    }

    public void setRegistros(List<T> registros) {
        this.registros = registros;
    }
}
