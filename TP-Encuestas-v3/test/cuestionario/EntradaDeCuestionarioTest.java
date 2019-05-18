package cuestionario;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import pregunta.Pregunta;
import respuesta.Respuesta;

class EntradaDeCuestionarioTest {
	
	@Test
	void puedo_pedirle_la_pregunta() {
		Pregunta unaPregunta = unaPregunta();
		EntradaDeCuestionario entrada = new EntradaDeCuestionario(unaPregunta, unaRespuesta());
		assertEquals(unaPregunta, entrada.pregunta());
	}
	
	@Test
	void puedo_pedirle_la_respuesta() {
		Respuesta unaRespuesta = unaRespuesta();
		EntradaDeCuestionario entrada = new EntradaDeCuestionario(unaPregunta(), unaRespuesta);
		assertEquals(unaRespuesta, entrada.respuesta());
	}
	
	protected Pregunta unaPregunta() {
		return mock(Pregunta.class);
	}
	
	protected Respuesta unaRespuesta() {
		return mock(Respuesta.class);
	}

}
