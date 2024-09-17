package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Sala;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SalaBeanTest {

    @Test
    void findById(){
        System.out.println("findById");
        List<Sala> buscados = Arrays.asList(new Sala(1), new Sala(2), new Sala(3));
        Query mockQuery = Mockito.mock(Query.class);
        Mockito.when(mockQuery.getResultList()).thenReturn(buscados);


        EntityManager mockEm = Mockito.mock(EntityManager.class);
        Mockito.when(mockEm.createNamedQuery("Sala.findByIdTipoSala")).thenReturn(mockQuery);


        SalaBean cut= new SalaBean();
        cut.em=mockEm;

        List<Sala> encontrados = cut.findByIdTipoSala(1,1,1);

        assertEquals(buscados.size(),encontrados.size());
    }
}
