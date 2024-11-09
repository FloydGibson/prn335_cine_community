package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoPeliculaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoPelicula;

@Named
@ViewScoped
public class FrmTipoPelicula extends AbstractPfFrm<TipoPelicula> {

    @Inject
    TipoPeliculaBean tplBean;

    @Inject
    FacesContext facesContext;

    @Override
    public FacesContext getFacesContext() {
        return facesContext;
    }

    @Override
    public AbstractDataPersistence<TipoPelicula> getDataBean(){
        return tplBean;
    }

    @Override
    public TipoPelicula createNewEntity(){
        return new TipoPelicula();
    }

    @Override
    public Object getId(TipoPelicula o){
        return o.getIdTipoPelicula();
    }

    @Override
    public String getTituloPag(){
        return "Tipo Pelicula";
    }

    @Override
    public TipoPelicula buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String buscarIdPorRegistro(TipoPelicula entity) {
        return "";
    }


}