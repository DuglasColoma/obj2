package pregunta;

import java.util.List;

import opcion.Opcion;
import respuesta.Respuesta;

public abstract class Pregunta {

	protected String textoConPregunta;

	public Pregunta(String unTextoConPregunta) {
		textoConPregunta = unTextoConPregunta;
	}

	public abstract boolean esValida(Respuesta unaRespuesta);

	// Queries
	public String textoConPregunta() {
		return textoConPregunta;
	}
	
	public abstract List<Opcion> opciones();
	
	public abstract Pregunta     siguientePreguntaParaCuandoSeDa(Respuesta unaRespuesta);
	
	/* PROTECTED */
	// Testing
	protected boolean tieneOpcion(Opcion unaOpcion) {
		return opciones().contains(unaOpcion);
	}

	protected boolean tieneTodasLasOpciones(List<Opcion> opciones) {
		return opciones
					.stream()
					.allMatch(this::tieneOpcion);
	}


}