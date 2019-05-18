package pregunta;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import opcion.Opcion;
import respuesta.Respuesta;

public class PreguntaSingleChoice extends Pregunta {

	private Map<Opcion,Pregunta> asociacionesOpcionPregunta;

	public PreguntaSingleChoice(
		String               textoConPregunta,
		Map<Opcion,Pregunta> asociacionesOpcionPregunta)
	{
		super(textoConPregunta);
		this.asociacionesOpcionPregunta = asociacionesOpcionPregunta;
	}

	// Testing
	public boolean esValida(Respuesta unaRespuesta) {
		return 	unaRespuesta.tieneUnaSolaOpcion() &&
				tieneOpcion(unaRespuesta.primerOpcion());
	}

	// Queries
	public List<Opcion> opciones() {
		return asociacionesOpcionPregunta
				.keySet()
				.stream()
				.collect(Collectors.toList());
	}

	public Pregunta siguientePreguntaParaCuandoSeDa(Respuesta unaRespuesta) {
		return asociacionesOpcionPregunta.get(unaRespuesta.primerOpcion());
	}
	
}
