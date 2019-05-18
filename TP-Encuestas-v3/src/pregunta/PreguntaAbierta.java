package pregunta;

import java.util.ArrayList;
import java.util.List;

import opcion.Opcion;
import respuesta.Respuesta;

public class PreguntaAbierta extends Pregunta {

	private Pregunta siguientePregunta;

	public PreguntaAbierta(String unTextoConPregunta, Pregunta siguientePregunta) {
		super(unTextoConPregunta);
		this.siguientePregunta = siguientePregunta;
	}

	// Testing
	public boolean esValida(Respuesta unaRespuesta) {
		return unaRespuesta.tieneUnaSolaOpcion();
	}

	// Queries
	public List<Opcion> opciones() {
		return new ArrayList<Opcion>();
	}

	public Pregunta siguientePreguntaParaCuandoSeDa(Respuesta unaRespuesta) {
		return siguientePregunta;
	}

}
