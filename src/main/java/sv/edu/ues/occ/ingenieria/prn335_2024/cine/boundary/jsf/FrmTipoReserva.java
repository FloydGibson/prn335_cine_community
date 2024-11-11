package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoReservaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoReserva;

import java.io.Serializable;

@Named
@ViewScoped
public class FrmTipoReserva extends AbstractFrm<TipoReserva> implements Serializable {

    @Inject
    TipoReservaBean trBean;

    @Inject
    FacesContext facesContext;

    @Override
    public String buscarIdPorRegistro(TipoReserva entity) {
        return "";
    }

    @Override
    public TipoReserva buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String getTituloDePagina() {
        return "tipo reserva";
    }

    @Override
    protected Object getId(TipoReserva reserva) {
        return reserva.getIdTipoReserva();
    }

    @Override
    protected TipoReserva createNewRegistro() {
        return new TipoReserva();
    }

    @Override
    public AbstractDataPersistence<TipoReserva> getDataBean() {
        return trBean;
    }

    @Override
    protected FacesContext getContext() {
        return facesContext;
    }

    public void btnCrearHandler(ActionEvent actionEvent) {
        super.btnCrearHandler(actionEvent);
    }

    public void btnModificarHandler(ActionEvent actionEvent) {
        super.btnModificarHandler(actionEvent);
    }

    public void btnEliminarHandler(ActionEvent actionEvent) {
        super.btnEliminarHandler(actionEvent);
    }

    public void btnCancelarHandler(ActionEvent actionEvent) {
        super.btnCancelarHandler(actionEvent);
    }

    public void btnNuevoHandler(ActionEvent actionEvent) {
        super.btnNuevoHandler(actionEvent);
    }


}
