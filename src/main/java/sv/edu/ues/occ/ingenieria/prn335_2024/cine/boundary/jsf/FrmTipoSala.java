package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoSalaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

@Named
@ViewScoped
public class FrmTipoSala extends AbstractPfFrm<TipoSala> {
//esta va por robin
    @Inject
    TipoSalaBean tslBean;

    @Inject
    FacesContext facesContext;

    @Override
    public FacesContext getFacesContext() {
        return facesContext;
    }

    @Override
    public AbstractDataPersistence<TipoSala> getDataBean(){
        return tslBean;
    }

    @Override
    public TipoSala createNewEntity(){
        return new TipoSala();
    }

    @Override
    public Object getId(TipoSala o){
        return o.getIdTipoSala();
    }

    @Override
    public String getTituloPag(){
        return "Tipo Sala";
    }

    @Override
    public TipoSala buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String buscarIdPorRegistro(TipoSala entity) {
        return "";
    }
}
