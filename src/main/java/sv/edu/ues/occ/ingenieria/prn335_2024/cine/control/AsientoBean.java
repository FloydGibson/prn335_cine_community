package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Asiento;
import jakarta.persistence.EntityManager;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Pago;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@LocalBean

public class AsientoBean extends AbstractDataPersistence<Asiento> implements Serializable{
    @PersistenceContext(unitName = "CinePU")
    EntityManager em;

    public AsientoBean() {
        super(Pago.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}