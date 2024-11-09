package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Pelicula;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.PeliculaCaracteristica;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@LocalBean

public class PeliculaCaracteristicaBean extends AbstractDataPersistence<PeliculaCaracteristica> implements Serializable{
    @PersistenceContext(unitName = "CinePU")
    EntityManager em;

    public PeliculaCaracteristicaBean() {
        super(Pelicula.class);
    }   

    @Override
    public EntityManager getEntityManager() {
        return em;
    }


    public List<PeliculaCaracteristica> findByIdPelicula(final long idPelicula,int min, int max) {
    try {

    } catch (Exception e){
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
    }

        return List.of();
    }
}