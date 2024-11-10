package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Sala;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class SalaBean extends AbstractDataPersistence<Sala> implements Serializable {
    @PersistenceContext(unitName = "CinePU")
    EntityManager em;


    public SalaBean(){
        super(Sala.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(Sala sala){
        super.create(sala);
    }

     //Esta es una consulta devuelve una lista de entidades de Sala, Usa la Query Sala.findByIdTipoSala


    public List<Sala> findByIdTipoSala(Integer idTipoSala, int first, int max) {
        if (idTipoSala != null) {
            try {
                if (em != null) {
                    Query q = em.createNamedQuery("Sala.findByIdTipoSala");
                    q.setParameter("idTipoSala", idTipoSala);
                    q.setFirstResult(first);
                    q.setMaxResults(max);
                    q.getMaxResults();
                    return q.getResultList();
                }

            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return Collections.emptyList();
    }

}