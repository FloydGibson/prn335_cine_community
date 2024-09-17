package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public abstract class AbstractDataPersist<T> {

public abstract EntityManager getEntityManager();


Class tipoDatos;
public AbstractDataPersist(Class tipoDatos){
    this.tipoDatos = tipoDatos;
}


    /**
     *
     * @param id Indentificador unico buscado
     * @return Nulo si no se encuentra o el registro encontrado
     *
     */
    public T findById(final Object id){
        EntityManager em = null;
        if (id == null){
            throw new IllegalArgumentException("id invalido");
        }
        try{
            em = getEntityManager();
            if (em == null){
                throw new IllegalStateException("Error al acceder al repositorio");
            }

        } catch (Exception ex) {
            throw new IllegalStateException("Error al acceder al repositorio",ex);
        }
        return (T) em.find(tipoDatos, id);
    }

    /**
     *
     * @param entity
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     */
    public void create(final T entity) throws IllegalStateException,IllegalArgumentException{
    EntityManager em = null;

    if (entity == null){
        throw new IllegalArgumentException("La entidad a persistir no puede ser nula");
    }
    try {
        em = getEntityManager();
        if (em == null){
            throw new IllegalStateException("Error al acceder al repositorio");
        }

        em.persist(entity);

    } catch (Exception ex){
        throw new IllegalStateException("Error al acceder al repositorio",ex);
    }
}

public List<T> findRange(int first, int max) throws IllegalStateException,IllegalArgumentException{
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery q = cb.createQuery(tipoDatos);
        Root<T> raiz = q.from(tipoDatos);
        CriteriaQuery cq = q.select(raiz);
        TypedQuery query = getEntityManager().createQuery(cq);
        query.setFirstResult(first);
        query.setMaxResults(max);
    return query.getResultList();
    }

}
