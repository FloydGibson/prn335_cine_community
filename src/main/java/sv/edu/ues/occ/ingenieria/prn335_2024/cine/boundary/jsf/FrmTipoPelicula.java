package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoPeliculaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoPelicula;

import java.io.Serializable;

@Named
@ViewScoped
public class FrmTipoPelicula extends AbstractFrm<TipoPelicula> implements Serializable {

    @Inject
    TipoPeliculaBean tpBean;

    @Inject
    FacesContext facesContext;

    @Override
    public String buscarIdPorRegistro(TipoPelicula entity) {
        return "";
    }

    @Override
    public TipoPelicula buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String getTituloDePagina() {
        return "tipo pelicula";
    }

    @Override
    protected Object getId(TipoPelicula pelicula) {
        return pelicula.getIdTipoPelicula();
    }

    @Override
    protected FacesContext facesContext() {
        return null;
    }

    @Override
    protected TipoPelicula createNewRegistro() {
        return new TipoPelicula();
    }

    @Override
    protected AbstractDataPersistence<TipoPelicula> getDataBean() {
        return tpBean;
    }

    @Override
    protected FacesContext getContext() {
        return facesContext;
    }
}
