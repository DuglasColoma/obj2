package cuestionario;

import pregunta.Pregunta;
import respuesta.Respuesta;

public class EntradaDeCuestionario {

	private Pregunta  pregunta;
	private Respuesta respuesta;

	public EntradaDeCuestionario(Pregunta unaPregunta, Respuesta unaRespuesta) {
		this.pregunta  = unaPregunta;
		this.respuesta = unaRespuesta;
	}

	public Pregunta pregunta() {
		return pregunta;
	}

	public Respuesta respuesta() {
		return respuesta;
	}
	
}
