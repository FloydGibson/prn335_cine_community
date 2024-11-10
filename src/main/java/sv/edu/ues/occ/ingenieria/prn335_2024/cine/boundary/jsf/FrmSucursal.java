package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.SucursalBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Sucursal;

@Named
@ViewScoped
public class FrmSucursal extends AbstractPfFrm<Sucursal> {

    @Inject
    SucursalBean sucBean;

    @Inject
    FacesContext facesContext;

    @Override
    public FacesContext getFacesContext() {
        return facesContext;
    }

    @Override
    public AbstractDataPersistence<Sucursal> getDataBean(){
        return sucBean;
    }


    @Override
    public Sucursal createNewEntity(){
        return new Sucursal();
    }

    @Override
    public Object getId(Sucursal o){
        return o.getIdSucursal().toString();
    }

    @Override
    public String getTituloPag(){
        return "Sucursal";
    }

    @Override
    public Sucursal buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String buscarIdPorRegistro(Sucursal entity) {
        return "";
    }
}

