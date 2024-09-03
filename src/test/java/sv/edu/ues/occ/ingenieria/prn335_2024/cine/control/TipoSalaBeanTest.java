package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoSala;

import static org.junit.jupiter.api.Assertions.*;

class TipoSalaBeanTest {

    @Test
    void findById() {
        System.out.println("TipoSalaBeanTest.findById");
        final Integer idEsperado = 1;
        TipoSala esperado= new TipoSala();
        TipoSalaBean cut = new TipoSalaBean();
        EntityManager mock= Mockito.mock(EntityManager.class);
        Mockito.when(mock.find(TipoSala.class, idEsperado)).thenReturn(esperado);
        cut.em=mock;

        TipoSala resultado= cut.findById(idEsperado);

        assertNotNull(resultado);
        assertEquals(esperado,resultado);
        //fail("Not yet implemented");
    }
@Test
    void sumar()   {
        System.out.println("TipoSalaBeanTest.sumar");
        int primero=1;
        int segundo=2;
        int esperado=3;
        int resultado=-1;
        //cut: Class Under Test
        TipoSalaBean cut = new TipoSalaBean();
        resultado=cut.sumar(primero,segundo);
        assertEquals(esperado,resultado);
        //fail("Not yet implemented");
    }
}