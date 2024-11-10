package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoReservaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoReserva;
import java.io.Serializable;

@Named
@ViewScoped
public class FrmTipoReserva extends AbstractPfFrm<TipoReserva> implements Serializable {

    @Inject
    TipoReservaBean trBean;

    @Inject
    FacesContext facesContext;

    @Override
    public FacesContext getFacesContext() {
        return facesContext;
    }

    @Override
    public AbstractDataPersistence<TipoReserva> getDataBean(){
        return trBean;
    }

    @Override
    public TipoReserva createNewEntity(){
        return new TipoReserva();
    }

    @Override
    public Object getId(TipoReserva o){
        return o.getIdTipoReserva();
    }

    @Override
    public String getTituloPag(){
        return "Tipo Reserva";
    }

    @Override
    public TipoReserva buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String buscarIdPorRegistro(TipoReserva entity) {
        return "";
    }


}