package cuestionario;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import opcion.Opcion;
import pregunta.Pregunta;
import pregunta.PreguntaAbierta;
import respuesta.Respuesta;

class CuestionarioTest {
	
	private Pregunta  primerPregunta;
	private Pregunta  segundaPregunta;

	@Test
	void inicialmente_la_pregunta_actual_es_la_que_se_le_paso_al_contructor() {
		Cuestionario cuestionario = new Cuestionario(primerPregunta);
		
		assertEquals(
			primerPregunta,
			cuestionario.preguntaActual());
	}
	
	@Test
	void cuando_registra_una_respuesta_valida_se_pasa_a_la_siguiente_pregunta() {
		//Pregunta     segundaPregunta = unaPreguntaSola();     
		Pregunta     primerPregunta  = unaPreguntaAbiertaCuyaSiguienteEs(segundaPregunta);
		Respuesta    unaRespuesta    = Respuesta.conUnaSolaOpcion(new Opcion("dasdas"));
		
		//when(primerPregunta.esValida(unaRespuesta)).thenReturn(true);
		//when(primerPregunta.siguientePreguntaParaCuandoSeDa(unaRespuesta)).thenReturn(segundaPregunta);
		
		Cuestionario cuestionario = new Cuestionario(primerPregunta);
		
		cuestionario.registrar(unaRespuesta);
		
		assertEquals(
			segundaPregunta,
			cuestionario.preguntaActual());
	}
	
	@Test
	void no_puede_registrar_una_respuesta_invalida() {
		Pregunta     primerPregunta    = new PreguntaAbierta("¿..?", null);
		Cuestionario cuestionario      = new Cuestionario(primerPregunta);
		Respuesta    respuestaInvalida = Respuesta.conVariasOpciones(Arrays.asList(new Opcion(null), new Opcion(null)));
		
		assertThrows(RuntimeException.class, () -> cuestionario.registrar(respuestaInvalida));
	}
	
	@Test
	void puede_volver_a_una_pregunta_anterior() {
		Pregunta     segundaPregunta = unaPreguntaSola();
		Pregunta     primerPregunta  = unaPreguntaAbiertaCuyaSiguienteEs(segundaPregunta);
		Respuesta    respuestaValida = Respuesta.conUnaSolaOpcion(new Opcion("dasdas"));
		Cuestionario cuestionario    = new Cuestionario(primerPregunta);
		cuestionario.registrar(respuestaValida);
		
		cuestionario.volverALaPreguntaAnterior();
		
		assertEquals(
			primerPregunta,
			cuestionario.preguntaActual());
	}
	
	/////////////////////
	private PreguntaAbierta unaPreguntaAbiertaCuyaSiguienteEs(Pregunta unaPregunta) {
		return new PreguntaAbierta("¿..?", unaPregunta);
	}
	
	private PreguntaAbierta unaPreguntaSola() {
		return new PreguntaAbierta("¿..?", null);
	}
}
