package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.SalaCaracteristicaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoSalaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Sala;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.SalaCaracteristica;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Named
@Dependent
public class FrmSalaCaracteristica extends AbstractFrm<SalaCaracteristica> implements Serializable {
    @Inject
    TipoSalaBean tsBean;

    @Inject
    SalaCaracteristicaBean scBean;

    @Inject
    FacesContext facesContext;

    List<TipoSala> tipoSalasList;

    Integer idSala;

    @PostConstruct
    public void inicializar() {
        super.inicializar();
        try {
            this.tipoSalasList = tsBean.findRange(0, Integer.MAX_VALUE);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            enviarMensaje("Error al cargar los tipos", "Error al cargar", FacesMessage.SEVERITY_ERROR);
        }
    }


    @Override
    public List<SalaCaracteristica> cargarDatos(int firstResult, int maxResults){
        try {
            if(this.idSala!=null && this.scBean!=null){
                return scBean.findByIdSala(this.idSala, firstResult, maxResults);
            }
        }catch (Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return List.of();
    }

    @Override
    public int contar(){
        try {
            if(this.idSala!=null && this.scBean!=null){
                return scBean.countSala(this.idSala);
            }
        }catch (Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    @Override
    public String getTituloDePagina(){return "Tipo de Sala";}

    @Override
    protected Object getId(SalaCaracteristica peliculaCaracteristica) {
        return peliculaCaracteristica.getIdSalaCaracteristica();
    }

    @Override
    protected  SalaCaracteristica createNewRegistro(){
        SalaCaracteristica pc = new SalaCaracteristica();
        if (idSala != null) {
            pc.setIdSala(new Sala(idSala));
        }
        if (tipoSalasList != null && tipoSalasList.isEmpty()) {
            pc.setIdTipoSala(tipoSalasList.getFirst());
        }
        return pc;
    }

    @Override
    protected AbstractDataPersistence<SalaCaracteristica> getDataBean() {
        return scBean;
    }

    @Override
    protected FacesContext getContext(){return facesContext;}

    @Override
    public SalaCaracteristica buscarRegistroPorId(String id){
        if(id!=null && this.modelo!=null){
            return this.modelo.getWrappedData().stream()
                    .filter(r ->r.getIdSalaCaracteristica().toString().equals(id)).findFirst().orElse(null);
        }
        return null;
    }

    @Override
    public String buscarIdPorRegistro(SalaCaracteristica dato){
        if(dato!=null && dato.getIdSalaCaracteristica()!=null){
            return dato.getIdSalaCaracteristica().toString();
        }
        return null;
    }

    public Integer getIdSala() {return idSala;}

    public void setIdSala(Integer idSala) {this.idSala = idSala;}

    public List<TipoSala> getTipoSalasList() {return tipoSalasList;}

    public Integer getIdTipoSalaSeleccionado() {
        if (this.registro != null && this.registro.getIdTipoSala() != null) {
            return this.registro.getIdTipoSala().getIdTipoSala();
        }
        return null;
    }

    public void setIdTipoSalaSeleccionado(final Integer idTipoSala) {
        if (this.registro != null && this.tipoSalasList != null && !this.tipoSalasList.isEmpty()) {
            this.registro.setIdTipoSala(this.tipoSalasList.stream()
                    .filter(r -> r.getIdTipoSala().equals(idTipoSala))
                    .findFirst()
                    .orElse(null));
        }
    }
    public void setTipoSalasList(List<TipoSala> tipoSalasList) {
        this.tipoSalasList = tipoSalasList;
    }

    public void validarValor(FacesContext fc, UIComponent componente, Object valor) {
        UIInput input = (UIInput) componente;
        if (registro != null && this.registro.getIdTipoSala() != null) {
            String nuevo = valor.toString();
            Pattern patron = Pattern.compile(this.registro.getIdTipoSala().getExpresionRegular());
            Matcher validator = patron.matcher(nuevo);
            if (validator.find()) {
                input.setValid(true);
                return;
            }
        }

        input.setValid(false);

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Advertencia", "Valor ingresado inválido."));

    }

}
