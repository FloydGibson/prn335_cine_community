package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoAsiento;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoAsiento;
import java.io.Serializable;

public class TipoAsientoBean extends AbstractDataPersist<TipoAsiento> implements Serializable {

    @PersistenceContext(unitName = "CinePU")
        EntityManager em;

    public TipoAsientoBean() {
        super(TipoAsiento.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}