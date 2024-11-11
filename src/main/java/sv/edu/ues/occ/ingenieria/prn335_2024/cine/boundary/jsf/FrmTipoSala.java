package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoSalaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

import java.io.Serializable;

@Named
@ViewScoped
public class FrmTipoSala extends AbstractFrm<TipoSala> implements Serializable {

    @Inject
    TipoSalaBean tsBean;

    @Inject
    FacesContext facesContext;

    @Override
    public String buscarIdPorRegistro(TipoSala entity) {
        return "";
    }

    @Override
    public TipoSala buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String getTituloDePagina() {
        return "tipo sala";
    }

    @Override
    protected Object getId(TipoSala sala) {
        return sala.getIdTipoSala();
    }

    @Override
    protected TipoSala createNewRegistro() {
        return new TipoSala();
    }

    @Override
    public AbstractDataPersistence<TipoSala> getDataBean() {
        return tsBean;
    }

    @Override
    protected FacesContext getContext() {
        return facesContext.getCurrentInstance();
    }
}
