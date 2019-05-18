package pregunta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import respuesta.Respuesta;

class PreguntaAbiertaTest extends PreguntaTest {

	protected Pregunta  pregunta;
	protected Pregunta  siguientePregunta;
	protected Respuesta unaRespuestaConUnaSolaOpcion;
	
	@BeforeEach
	void setUp() throws Exception {
		siguientePregunta = mock(Pregunta.class);
		pregunta          = new PreguntaAbierta(texto(), siguientePregunta);
	}

	@Test
	void tiene_un_texto_con_una_pregunta() {
		assertEquals(texto(), pregunta.textoConPregunta());
	}
	
	@Test
	void no_tiene_opciones() {
		assertTrue(pregunta.opciones().isEmpty());
	}
	
	@Test
	void una_respuesta_con_una_sola_opcion_elegida_es_valida() {
		assertTrue(pregunta.esValida(unaRespuestaConUnaSolaOpcionElegida()));
	}
	
	@Test
	void una_respuesta_que_no_tiene_una_sola_opcion_elegida_es_invalida() {
		assertFalse(pregunta.esValida(unaRespuestaQueNoTieneUnaSolaOpcionElegida()));
	}
	
	@Test
	void la_siguiente_pregunta_es_la_misma_para_cualquier_respuesta_valida() {
		Respuesta unaRespuestaValida = respuestaConUnaSolaOpcionElegida();
		
		assertEquals(
			siguientePregunta,
			pregunta.siguientePreguntaParaCuandoSeDa(unaRespuestaValida));
	}
	
}
