package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoProductoBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoPelicula;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoProducto;

@Named
@ViewScoped
public class FrmTipoProducto extends AbstractPfFrm<TipoProducto> {

    @Inject
    TipoProductoBean tprBean;

    @Inject
    FacesContext facesContext;

    @Override
    public FacesContext getFacesContext() {
        return facesContext;
    }

    @Override
    public AbstractDataPersistence<TipoProducto> getDataBean(){
        return tprBean;
    }

    @Override
    public TipoProducto createNewEntity(){
        return new TipoProducto();
    }

    @Override
    public Object getId(TipoProducto o){
        return o.getIdTipoProducto();
    }

    @Override
    public String getTituloPag(){
        return "Tipo Producto";
    }

    @Override
    public TipoProducto buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String buscarIdPorRegistro(TipoProducto entity) {
        return "";
    }

}