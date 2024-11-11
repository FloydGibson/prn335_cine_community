package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoPagoBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoPago;

import java.io.Serializable;

@Named
@ViewScoped
public class FrmTipoPago extends AbstractFrm<TipoPago> implements Serializable {

    @Inject
    TipoPagoBean tpBean;

    @Inject
    FacesContext facesContext;

    @Override
    public String buscarIdPorRegistro(TipoPago entity){
        return "";
    }
    @Override
    public TipoPago buscarRegistroPorId(String id){
        return null;
    }
    @Override
    public String getTituloDePagina() {
        return "tipo pago";
    }

    @Override
    protected Object getId(TipoPago pago) {
        return pago.getIdTipoPago();
    }

    @Override
    protected TipoPago createNewRegistro() {
        return new TipoPago();
    }

    @Override
    protected AbstractDataPersistence<TipoPago> getDataBean() {
        return tpBean;
    }
    @Override
    protected FacesContext getContext() {
        return facesContext;
    }
}
