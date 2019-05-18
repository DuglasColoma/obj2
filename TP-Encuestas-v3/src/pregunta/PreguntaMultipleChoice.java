package pregunta;

import java.util.List;

import opcion.Opcion;
import respuesta.Respuesta;

public class PreguntaMultipleChoice extends Pregunta {

	private List<Opcion> opciones;
	private Pregunta     siguientePregunta;

	public PreguntaMultipleChoice(String unTextoConPregunta, List<Opcion> opciones, Pregunta siguientePregunta) {
		super(unTextoConPregunta);
		this.opciones          = opciones;
		this.siguientePregunta = siguientePregunta;
	}

	// Testing
	public boolean esValida(Respuesta unaRespuesta) {
		return tieneTodasLasOpciones(unaRespuesta.opcionesElegidas());
	}

	// Queries
	public List<Opcion> opciones() {
		return opciones;
	}

	public Pregunta siguientePreguntaParaCuandoSeDa(Respuesta unaRespuesta) {
		return siguientePregunta;
	}

}
