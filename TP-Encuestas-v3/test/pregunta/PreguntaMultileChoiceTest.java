package pregunta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import opcion.Opcion;
import respuesta.Respuesta;

class PreguntaMultileChoiceTest extends PreguntaTest {

	private Pregunta     pregunta;
	private Pregunta     siguientePregunta;
	
	private List<Opcion> opciones;
	
	private Opcion       opcionA;
	private Opcion       opcionB;
	private Opcion       opcionC;
	private Opcion       opcionInvalida;
	
	private Respuesta    respuesta;
	
	@BeforeEach
	void setUp() throws Exception {
		respuesta = mock(Respuesta.class);
		
		siguientePregunta = mock(Pregunta.class);
		
		opcionA           = mock(Opcion.class);
		opcionB           = mock(Opcion.class);
		opcionC           = mock(Opcion.class);
		
		opcionInvalida    = mock(Opcion.class);
		
		opciones          = Arrays.asList(opcionA, opcionB, opcionC);
		
		pregunta          = new PreguntaMultipleChoice(texto(), opciones, siguientePregunta);
	}

	@Test
	void tiene_un_texto_con_una_pregunta() {
		assertEquals(texto(), pregunta.textoConPregunta());
	}
	
	@Test
	void tiene_opciones() {
		assertEquals(opciones, pregunta.opciones());
	}
	
	@Test
	void una_respuesta_es_valida_si_las_opciones_elegidas_son_las_que_conoce_la_pregunta() {
		when(respuesta.opcionesElegidas()).thenReturn(pregunta.opciones());
		
		assertTrue(pregunta.esValida(respuesta));
	}
	
	@Test
	void una_respuesta_no_es_valida_si_alguna_opcion_elegida_no_esta_en_la_pregunta() {
		when(respuesta.opcionesElegidas()).thenReturn(Arrays.asList(opcionInvalida));
		
		assertFalse(pregunta.esValida(respuesta));
	}
	
	@Test
	void _la_siguiente_pregunta_es_la_misma_para_cualquier_pregunta_valida() {
		when(respuesta.opcionesElegidas()).thenReturn(pregunta.opciones());
		assertEquals(siguientePregunta, pregunta.siguientePreguntaParaCuandoSeDa(respuesta));
	}
	
}
