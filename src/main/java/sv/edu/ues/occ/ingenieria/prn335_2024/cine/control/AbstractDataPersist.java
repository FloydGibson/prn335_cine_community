package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.persistence.EntityManager;

public abstract class AbstractDataPersist<T> {

public abstract EntityManager getEntityManager();


Class tipoDatos;
public AbstractDataPersist(Class tipoDatos){
    this.tipoDatos = tipoDatos;
}

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
}
