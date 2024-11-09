package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoPagoBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoPago;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoPelicula;

import java.io.Serializable;

@Named
@ViewScoped
public class FrmTipoPago extends AbstractPfFrm<TipoPago> implements Serializable {

    @Inject
    TipoPagoBean tpBean;

    @Inject
    FacesContext facesContext;

    @Override
    public FacesContext getFacesContext() {
        return facesContext;
    }

    @Override
    public AbstractDataPersistence<TipoPago> getDataBean(){
        return tpBean;
    }

    @Override
    public TipoPago createNewEntity(){
        return new TipoPago();
    }

    @Override
    public Object getId(TipoPago o){
        return o.getIdTipoPago().toString();
    }

    @Override
    public String getTituloPag(){
        return "Tipo Pago";
    }

    @Override
    public TipoPago buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String buscarIdPorRegistro(TipoPago entity) {
        return "";
    }


}