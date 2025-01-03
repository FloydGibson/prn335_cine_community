package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoSalaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class FrmTipoSalaF extends AbstracBasicFrm<TipoSala> implements Serializable {

    @Inject
    TipoSalaBean tsBean;

    @Inject
    FacesContext facesContext;

    @Override
    protected Object getId(TipoSala sala) {
        return sala.getIdTipoSala();
    }

    @Override
    protected AbstractDataPersistence<TipoSala> getDataBean() {
        return tsBean;
    }

    @Override
    protected FacesContext facesContext() {
        return facesContext;
    }

    @Override
    protected TipoSala createNewRegistro() {
        return new TipoSala();
    }


    ESTADO_CRUD estado;

    List<TipoSala> registros;

    @PostConstruct //Solo lo puedo usar una vez por clase
    public void init() {
        estado = ESTADO_CRUD.NINGUNO;
        registros = tsBean.findRange(0, 10000000);
    }

    TipoSala registro;

    public void btnSeleccionarRegistroHandler(final Integer idTipoSala) {
        if (idTipoSala != null) {
            this.registro = this.registros.stream().filter(r -> idTipoSala.equals(r.getIdTipoSala())).findFirst().orElse(null);
            this.estado= ESTADO_CRUD.MODIFICAR;
            return;
        }
        this.registro = null;
    }

    public void btnCancelarHandler( ActionEvent actionEvent) {
        this.estado= ESTADO_CRUD.NINGUNO;
        this.registro = null;
    }

    public List<TipoSala> getRegistros() {
        return registros;
    }

    public void setRegistros(List<TipoSala> registros) {
        this.registros = registros;
    }

    public Integer getSeleccionado() {
        if (registro == null) {
            return null;
        }
        return registro.getIdTipoSala();
    }

    public void setSeleccionado(Integer seleccionado) {
        this.registro = this.registros.stream().filter(r -> r.getIdTipoSala() == seleccionado).collect(Collectors.toList()).getFirst();
        if(this.registro != null) {
            this.estado= ESTADO_CRUD.MODIFICAR;
        }
    }

    public TipoSala getRegistro() {
        return registro;
    }

    public void setRegistro(TipoSala registro) {
        this.registro = registro;
    }

    public void btnNuevoHandler(ActionEvent actionEvent) {
        this.registro = new TipoSala();
        this.registro.setActivo(true);
        this.registro.setExpresionRegular(".");
        this.estado = ESTADO_CRUD.CREAR;
    }

    public void btnGuardarHandler(ActionEvent actionEvent) {
        this.tsBean.create(registro);
        this.registro= null;
        this.registros = tsBean.findRange(0,1000000);
    }

    public ESTADO_CRUD getEstado() {
        return estado;
    }

    public void btnModificarHandler(ActionEvent actionEvent) {
        FacesMessage mensaje = new FacesMessage();
        TipoSala actualizado = tsBean.update(registro);
        if(actualizado!=null){
            this.registro = null;
            this.estado= ESTADO_CRUD.NINGUNO;
            mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
            mensaje.setSummary("Registro modificado con éxito");
        }else{
            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
            mensaje.setSummary("No se pudo guardar el registro, revise sus datos");
        }
        facesContext.addMessage(null, mensaje);

    }

    public void btnEliminarHandler(ActionEvent actionEvent) {
        FacesMessage mensaje = new FacesMessage();
        tsBean.delete(registro);
        mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
        mensaje.setSummary("Registro eliminado con exito");
        facesContext.addMessage(null, mensaje);
        this.registro = null;
        this.estado = ESTADO_CRUD.NINGUNO;
        this.registros = tsBean.findRange(0,1000000);
    }
}


