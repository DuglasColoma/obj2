package respuesta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import opcion.Opcion;
import static org.mockito.Mockito.*;

class RespuestaTest {
	
	@Test
	void una_respuesta_simple_tiene_una_sola_opcion() {
		Opcion unaOpcion = mock(Opcion.class);
		
		Respuesta respuesta = Respuesta.conUnaSolaOpcion(unaOpcion);
		
		assertEquals(1, respuesta.cantidadDeOpcionesElegidas());
		assertTrue(respuesta.opcionesElegidas().contains(unaOpcion));
	}

}
