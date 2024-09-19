package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Asiento;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AsientoBean extends AbstractDataPersist<Asiento> implements Serializable {

    @PersistenceContext(unitName = "CinePU")
    EntityManager em;

    public AsientoBean() {
        super(Asiento.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public List<Asiento> findByIdSala(Long idSala, int first, int max) {
        if (idSala != null && first >= 0 && max > 0) {
            try {
                if (em != null) {
                    Query q = em.createNamedQuery("Asiento.findByIdSala");
                    q.setParameter("idSala", idSala);
                    q.setFirstResult(first);
                    q.setMaxResults(max);
                    return q.getResultList();
                }

            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return Collections.emptyList();
    }
}