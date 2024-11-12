package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;
import java.util.List;

public abstract class AbstractDataPersistence<T> {

    public abstract EntityManager getEntityManager();

    Class tipoDatos;

    public AbstractDataPersistence(Class tipoDatos) {
        this.tipoDatos = tipoDatos;
    }


    public void create(T entity) throws IllegalArgumentException, IllegalStateException {

        EntityManager em = null;
        em = getEntityManager();

        if (entity == null) {
            throw new IllegalArgumentException("Entity null no puede ser persistir");
        }

        try {
            em.persist(entity);
        } catch (Exception e) {

            throw new IllegalStateException("Error acceder repositorio", e);
        }
    }

    public void delete(T entity) throws IllegalStateException, IllegalArgumentException {
        if (entity == null) {
            throw new IllegalArgumentException("La entidad no puede ser nula");
        }

        EntityManager em = null;
        try {
            // Obtener el EntityManager
            em = getEntityManager();
            if (em == null) {
                throw new IllegalStateException("Error al acceder al repositorio");
            }

            // Verificar si la entidad está en el contexto de persistencia
            if (em.contains(entity)) {
                // La entidad está gestionada, se puede eliminar directamente
                em.remove(entity);
            } else {
                // La entidad no está gestionada, primero se debe hacer un merge
                T managedEntity = em.merge(entity);
                em.remove(managedEntity);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Error al acceder al repositorio", e);
        }
    }





    public T update(T entity) throws IllegalStateException, IllegalArgumentException {
        EntityManager em = null;
        if (entity == null) {
            throw new IllegalArgumentException("La entidad no puede ser nula");
        }
        try {
            em = getEntityManager();
            if (em == null) {
                throw new IllegalStateException("Error al acceder al repositorio");
            }
            T updatedEntity = em.merge(entity);
            return updatedEntity;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir cambios en caso de error
            }
            throw new IllegalStateException("Error al acceder al repositorio", e);
        }
    }







    public T findById(final Object idTipo) throws IllegalArgumentException,IllegalStateException {
        EntityManager em=null;
        if(idTipo==null){
            throw  new IllegalArgumentException("Tipo de sala no encontrado");
        }
        try{
            em=getEntityManager();
            if(em==null){
                throw new IllegalStateException("No se encontro el EntityManager");
            }
        }catch (Exception ex){
            throw new IllegalStateException("No se encontró el entity manager",ex);
        }
        //return em.find(TipoSala.class,id);
        // return (TipoDatos) em.find(tipoDatos,id);

        return (T) em.find(tipoDatos,idTipo);

        //return em.find(tipoDatos,id);

    }

    public List<T> findRange (int first, int max){
        EntityManager em=null;
        if (first < 0 || max < 0) {
            throw new IllegalArgumentException("First argument must be a positive integer");
        }
        if(max < first){
            throw new IllegalArgumentException("Max argument must be a positive integer");
        }
        em = getEntityManager();

        if (em == null) {
            throw new IllegalStateException("No se encontró el EntityManager");
        }

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<T> q = cb.createQuery(this.tipoDatos);
            Root<T> raiz = q.from(this.tipoDatos);
            q.select(raiz);
            TypedQuery<T> query = em.createQuery(q);


            query.setFirstResult(first);
            query.setMaxResults(max);

            return query.getResultList();
        } catch (Exception ex) {
            throw new IllegalStateException("Error al acceder al repositorio", ex);
        }


    }



    public Long count() throws IllegalStateException {
        EntityManager em = null;

        try {
            em = getEntityManager();

            if (em == null) {
                throw new IllegalStateException("Error al acceder al repositorio");
            }

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class); // Definir que queremos un resultado de tipo Long
            Root<T> raiz = cq.from(tipoDatos);
            cq.select(cb.count(raiz)); // Utilizar el método count

            TypedQuery<Long> query = em.createQuery(cq);
            return query.getSingleResult(); // Obtener el resultado único de la consulta

        } catch (Exception e) {
            throw new IllegalStateException("Error al acceder al repositorio", e);
        }
    }

    public String imprimirCarnet(){
        return "OC22002";
    }

    public Class getTipoDatos() {
        return tipoDatos;
    }

    public void setTipoDatos(Class tipoDatos) {
        this.tipoDatos = tipoDatos;
    }
}