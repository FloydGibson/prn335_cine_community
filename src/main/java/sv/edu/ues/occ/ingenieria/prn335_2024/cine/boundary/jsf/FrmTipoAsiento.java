package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoAsientoBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoAsiento;

import java.io.Serializable;

@Named
@ViewScoped
public class FrmTipoAsiento extends AbstractPfFrm<TipoAsiento> implements Serializable {

    @Inject
    TipoAsientoBean taBean;

    @Inject
    FacesContext facesContext;

    @Override
    public FacesContext getFacesContext() {
        return facesContext;
    }

    @Override
    public AbstractDataPersistence<TipoAsiento> getDataBean(){
        return taBean;
    }


    @Override
    public TipoAsiento createNewEntity(){
        return new TipoAsiento();
    }

    @Override
    public Object getId(TipoAsiento o){

        return o.getIdTipoAsiento();
    }
    @Override
    public String getTituloPag(){
        return "Tipo Asiento";
    }

    @Override
    public TipoAsiento  buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String buscarIdPorRegistro(TipoAsiento entity) {
        return "";
    }
}