package pregunta;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import opcion.Opcion;
import respuesta.Respuesta;

public class PreguntaTest {
	
	protected String texto() {
		return "�...?";
	}
	
	protected Respuesta respuestaConUnaSolaOpcionElegida() {
		Respuesta respuesta = mock(Respuesta.class);
		when(respuesta.tieneUnaSolaOpcion()).thenReturn(true);
		return respuesta;
	}
	
	protected Respuesta respuestaEnLaQueSoloFigura(Opcion unaOpcionValida) {
		Respuesta respuesta = respuestaConUnaSolaOpcionElegida();
		when(respuesta.primerOpcion()).thenReturn(unaOpcionValida);
		return respuesta;
	}
	/*
	protected Respuesta respuestaQueTengaTodasLasOpcionesDe(Pregunta unaPregunta) {
		return respuestaConVariasOpciones(unaPregunta.opciones());
	}
	
	protected Respuesta respuestaConVariasOpciones(List<Opcion> opciones) {
		return Respuesta.multiple(opciones);
	}

	protected Respuesta ningunaRespuesta() {
		return Respuesta.ninguna();
	}
*/	
	/////////
	protected Respuesta unaRespuestaConUnaSolaOpcionElegida() {
		Respuesta respuesta = mock(Respuesta.class);
		when(respuesta.tieneUnaSolaOpcion()).thenReturn(true);
		return respuesta;
	}
	
	protected Respuesta unaRespuestaQueNoTieneUnaSolaOpcionElegida() {
		Respuesta respuesta = mock(Respuesta.class);
		when(respuesta.tieneUnaSolaOpcion()).thenReturn(false);
		return respuesta;
	}
}
