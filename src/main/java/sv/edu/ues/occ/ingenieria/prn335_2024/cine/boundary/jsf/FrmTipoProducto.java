package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoProductoBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoProducto;

import java.io.Serializable;

@Named
@ViewScoped
public class FrmTipoProducto extends AbstractFrm<TipoProducto> implements Serializable {
    @Inject
    TipoProductoBean tprBean;

    @Inject
    FacesContext facesContext;

    @Override
    public String buscarIdPorRegistro(TipoProducto entity) {
        return "";
    }

    @Override
    public TipoProducto buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String getTituloDePagina() {
        return "tipo producto";
    }

    @Override
    protected Object getId(TipoProducto producto) {
        return producto.getIdTipoProducto();
    }

    @Override
    protected FacesContext facesContext() {
        return null;
    }

    @Override
    protected TipoProducto createNewRegistro() {
        return new TipoProducto();
    }

    @Override
    protected AbstractDataPersistence<TipoProducto> getDataBean() {
        return tprBean;
    }

    @Override
    protected FacesContext getContext() {
        return facesContext;
    }
}
