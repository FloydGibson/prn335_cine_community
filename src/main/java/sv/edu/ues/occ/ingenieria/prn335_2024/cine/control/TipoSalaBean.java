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
    @PersistenceContext(unitName = "CinePU")
    EntityManager em;

    /**
     * Busca un TipoSala en el repo por su ID
     * @param idTipoSala, identificador del tipo sala
     * @return Nulo si no lo encuentra o el objeto encontrado
     * @throws IllegalArgumentException si el ID pasado es nulo o menor a cer
     * @throws IllegalStateException Si hay un problema con el repo
     */

    public TipoSala findById(final Integer idTipoSala){
if (idTipoSala == null||idTipoSala<=0){
    throw new IllegalArgumentException("idTipoSala invalido");
}
        try{
    if (idTipoSala == null){
        throw new IllegalStateException("Error al acceder al repositorio");
    }

} catch (Exception ex) {
    throw new IllegalStateException("Error al acceder al repositorio",ex);
}
        return em.find(TipoSala.class, idTipoSala);
    }


    public int sumar(int primero, int segundo) {
        return primero + segundo;
    }
}
