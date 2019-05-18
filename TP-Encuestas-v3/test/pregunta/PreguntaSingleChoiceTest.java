package pregunta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import opcion.Opcion;
import respuesta.Respuesta;

class PreguntaSingleChoiceTest extends PreguntaTest {

	private Pregunta pregunta;
	
	private HashMap<Opcion, Pregunta> asociacionOpcionesPreguntas;
	
	private Opcion opcionA;
	private Opcion opcionB;
	private Opcion opcionC;
	
	private Opcion opcionInvalida;

	private Pregunta preguntaA;
	private Pregunta preguntaB;
	private Pregunta preguntaC;
	
	private Respuesta unaRespuesta;
	
	@BeforeEach
	void setUp() throws Exception {
		unaRespuesta = mock(Respuesta.class);
		
		opcionA = mock(Opcion.class);
		opcionB = mock(Opcion.class);
		opcionC = mock(Opcion.class);
		opcionInvalida = mock(Opcion.class);
		
		preguntaA = mock(Pregunta.class);
		preguntaB = mock(Pregunta.class);
		preguntaC = mock(Pregunta.class);
		
		
		asociacionOpcionesPreguntas = new HashMap<Opcion,Pregunta>();
		asociacionOpcionesPreguntas.put(opcionA, preguntaA);
		asociacionOpcionesPreguntas.put(opcionB, preguntaB);
		asociacionOpcionesPreguntas.put(opcionC, preguntaC);
		
		pregunta = new PreguntaSingleChoice(texto(), asociacionOpcionesPreguntas);
	}

	@Test
	void tiene_un_texto_con_una_pregunta() {
		assertEquals(texto(), pregunta.textoConPregunta());
	}
	
	@Test
	void tiene_opciones() { // TODO: arreglar esto
		List<Opcion> opciones = pregunta.opciones();
		assertTrue(opciones.containsAll(asociacionOpcionesPreguntas.keySet()));
	}
	
	@Test
	void una_respuesta_es_valida_si_tiene_una_sola_opcion_que_es_conocida_por_la_pregunta() {
		Opcion unaOpcionValida = pregunta.opciones().get(0);
		
		unaRespuesta = respuestaEnLaQueSoloFigura(unaOpcionValida);
		
		assertTrue(pregunta.esValida(unaRespuesta));
	}
	
	@Test
	void una_respuesta_no_es_valida_si_tiene_alguna_opcion_elegida_que_no_es_conocida_por_la_pregunta() {
		Respuesta unaRespuestaInvalida = respuestaEnLaQueSoloFigura(opcionInvalida);
		
		assertFalse(pregunta.esValida(unaRespuestaInvalida));
	}
	
	@Test
	void una_respuesta_no_es_valida_si_tiene_mas_de_una_opcion_elegida() {
		when(unaRespuesta.tieneUnaSolaOpcion()).thenReturn(false);
		
		assertFalse(pregunta.esValida(unaRespuesta));
	}
	
	@Test
	void _la_siguiente_pregunta_es_depende_de_la_opcion_elegida() {
		Opcion    opcionElegida             = pregunta.opciones().get(0);
		Respuesta respuestaValida           = Respuesta.conUnaSolaOpcion(opcionElegida);
		Pregunta  siguientePreguntaEsperada = asociacionOpcionesPreguntas.get(opcionElegida);
		
		assertEquals(siguientePreguntaEsperada, pregunta.siguientePreguntaParaCuandoSeDa(respuestaValida));
	}
	
}
