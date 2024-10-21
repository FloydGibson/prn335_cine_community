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

    public AbstractDataPersist(Class tipoDatos) {
        this.tipoDatos = tipoDatos;
    }


    /*
      Almacena el registro en el repositorio
      param entity registro a almacenar
      ex1 acces no se puede acceder al repo
      Argument si el registro es nulo
      Generar javadoc?
       */
    public void create(T entity) throws IllegalArgumentException, IllegalStateException {

        EntityManager em = null;
        em = getEntityManager();

        if (entity == null) {
            throw new IllegalArgumentException("Entity null no puede ser persistir");
        }

        try {
            em.persist(entity);
        } catch (Exception e) {
            // excepcion java lang, no requiere la dependencia
            throw new IllegalStateException("Error acceder repositorio", e);
        }
    }

    public void delete(T entity) throws IllegalStateException, IllegalArgumentException {
        EntityManager em = null;
        if (entity == null) {
            throw new IllegalArgumentException("Entity null no puede ser persistir");
        }
        try {
            em = getEntityManager();
            if (em == null) {
                throw new IllegalStateException("Error al acceder al repositorio");
            }
            //T managedEntity = em.merge(entity);
            em.remove(entity);
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
            throw new IllegalStateException("Error al acceder al repositorio", e);
        }
    }


    public T findById(final Object idTipo) throws IllegalArgumentException, IllegalStateException {
        EntityManager em = null;
        if (idTipo == null) {
            throw new IllegalArgumentException("Tipo de sala no encontrado");
        }
        try {
            em = getEntityManager();
            if (em == null) {
                throw new IllegalStateException("No se encontro el EntityManager");
            }
        } catch (Exception ex) {
            throw new IllegalStateException("No se encontró el entity manager", ex);
        }
        //return em.find(TipoSala.class,id);
        // return (TipoDatos) em.find(tipoDatos,id);

        return (T) em.find(tipoDatos, idTipo);

        //return em.find(tipoDatos,id);

    }

    public List<T> findRange(int min, int max) {
        // validacion
        if (min < 0 || max < 0) {
            throw new IllegalArgumentException("Ambos parametros tienen que ser positivos.");
        }

        EntityManager em = getEntityManager();
        if (em == null) {
            throw new IllegalStateException("El EntityManager no se invoco correctamente.");
        }

        // CriteriaBuilder y CriteriaQuery
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(tipoDatos);
        Root<T> raiz = q.from(tipoDatos);
        q.select(raiz);

        // corriendo la query
        TypedQuery<T> query = em.createQuery(q);
        query.setFirstResult(min);
        query.setMaxResults(max);

        return query.getResultList();
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

    public String imprimirCarnet() {
        return "OC22002";
    }
    }
