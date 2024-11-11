package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;



import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.TabChangeEvent;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.SalaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Sala;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class FrmSala extends AbstractFrm<Sala> implements Serializable {


    @Inject
    SalaBean sBean;

    @Inject FacesContext facesContext;

    @Inject
    FrmSalaCaracteristica frmSalaCaracteristica;

    public void cambiarTab(TabChangeEvent tce){
        if(tce.getTab().getTitle().equals("Tipos")){
            if(this.registro != null && this.frmSalaCaracteristica != null){
                this.frmSalaCaracteristica.setIdSala(this.registro.getIdSala());
            }
        }
    }



    @Override
    public String getTituloDePagina() {
        return "Sala";
    }

    @Override
    protected Object getId(Sala object) {
        return object.getIdSala();
    }

    @Override
    protected Sala createNewRegistro() {
        return new Sala();
    }

    @Override
    protected AbstractDataPersistence<Sala> getDataBean() {
        return sBean;
    }

    @Override
    protected FacesContext getContext() {
        return facesContext;
    }

    @Override
    public String buscarIdPorRegistro(Sala entity) {
        if(entity!=null && entity.getSalaCaracteristicaList() !=null){
            return entity.getIdSala().toString();
        }
        return null;
    }

    @Override
    public Sala buscarRegistroPorId(String id) {
        if(id != null && this.modelo != null){
            return this.modelo.getWrappedData().stream().filter(r->r.getIdSala().toString().equals(id))
                    .findFirst().orElse(null);
        }
        return null;
    }


    public FrmSalaCaracteristica getFrmSalaCaracteristica() {
        return frmSalaCaracteristica;
    }
}