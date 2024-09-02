package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

import java.util.List;
import java.io.Serializable;
@Stateless
@LocalBean
public class TipoSalaBean implements Serializable {
    @PersistenceContext
    EntityManager em;

    public list<TipoSala> findById(final Integer idTipoSala);{
        em.find();
    }




}
