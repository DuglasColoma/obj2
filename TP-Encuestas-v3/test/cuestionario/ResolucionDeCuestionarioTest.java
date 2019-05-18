package cuestionario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ResolucionDeCuestionarioTest {
	
	private ResolucionDeCuestionario resolucion1;
	private EntradaDeCuestionario entradaCuestionario;
	
	@BeforeEach
	void setUp() {
		resolucion1 = new ResolucionDeCuestionario();
		entradaCuestionario = mock(EntradaDeCuestionario.class);
	}
	
	@Test
	void inicialmenteNoTieneRespuestasRegistradas() {
		assertTrue(resolucion1.contestaciones().isEmpty());
	}
	
	@Test
	void seRegistraUnaEntrada() {
		resolucion1.registrar(entradaCuestionario);
		assertEquals(1, resolucion1.contestaciones().size());
		assertTrue(resolucion1.contestaciones().contains(entradaCuestionario));
	}
	
	@Test
	void seEliminaLaUltimaEntrada() {
		resolucion1.registrar(entradaCuestionario);
		resolucion1.eliminarUltimaEntrada();
		assertTrue(resolucion1.contestaciones().isEmpty());
	}

}
