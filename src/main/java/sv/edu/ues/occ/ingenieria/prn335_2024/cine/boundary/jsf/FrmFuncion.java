package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;


import jakarta.enterprise.context.Dependent;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersistence;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.ProgramacionBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoPeliculaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Programacion;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoPelicula;

@Named
@Dependent
public class FrmFuncion extends AbstractPfFrm<Programacion>{

    @Inject
    ProgramacionBean programacionBean;

    @Inject
    FacesContext facesContext;

    @Override
    public FacesContext getFacesContext() {
        return facesContext;
    }

    @Override
    public AbstractDataPersistence<Programacion> getDataBean(){
        return programacionBean;
    }

    @Override
    public Programacion createNewEntity(){
        return new Programacion();
    }

    @Override
    public Object getId(Programacion o){
        return o.getIdProgramacion();
    }

    @Override
    public String getTituloPag(){
        return "Programacion";
    }

    @Override
    public Programacion buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String buscarIdPorRegistro(Programacion entity) {
        return "";
    }

}