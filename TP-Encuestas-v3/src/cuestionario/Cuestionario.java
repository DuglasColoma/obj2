package cuestionario;

import java.util.ArrayList;
import java.util.Stack;

import pregunta.Pregunta;
import respuesta.Respuesta;

public class Cuestionario {

	private Pregunta                     preguntaActual;
	private Stack<EntradaDeCuestionario> contestaciones;
	private ArrayList<ResolucionDeCuestionario> resolucionesDelCuestionario;
	
	public Cuestionario(Pregunta primerPregunta) {
		this.preguntaActual = primerPregunta;
		this.contestaciones = new Stack<EntradaDeCuestionario>();
		this.resolucionesDelCuestionario = new ArrayList<ResolucionDeCuestionario>();
	}
	
	// Queries
	public Pregunta preguntaActual() {
		return preguntaActual;
	}

	// Commands
	public void volverALaPreguntaAnterior() {
		laPreguntaActualAhoraEs(preguntaAnterior());
		borrarUltimaContestacion();
	}
	
	public void registrar(Respuesta unaRespuesta) {
		if (esValida(unaRespuesta))
			procesarRespuestaValida(unaRespuesta);
		else
			procesarRespuestaInvalida(unaRespuesta);
	}
	
	/* PROTECTED */
	// Queries
	protected Pregunta preguntaAnterior() {
		return contestaciones.peek().pregunta();
	}
	
	// Testing
	protected boolean esValida(Respuesta unaRespuesta) {
		return preguntaActual().esValida(unaRespuesta);
	}
	
	// Commands
	protected void procesarRespuestaValida(Respuesta unaRespuesta) {
		dejarContanciaDeQueSeDio(unaRespuesta);
		irAPreguntaQueSigueDespuesDeHaberDado(unaRespuesta);
	}

	protected void procesarRespuestaInvalida(Respuesta unaRespuesta) {
		throw new RuntimeException("Respuesta invalida");
	}

	protected void dejarContanciaDeQueSeDio(Respuesta unaRespuesta) {
		contestaciones.push(
				new EntradaDeCuestionario(
						preguntaActual(),
						unaRespuesta));
	}
	
	protected void irAPreguntaQueSigueDespuesDeHaberDado(Respuesta unaRespuesta) {
		laPreguntaActualAhoraEs(
			preguntaActual().siguientePreguntaParaCuandoSeDa(unaRespuesta)
		);
	}
	
	protected void laPreguntaActualAhoraEs(Pregunta unaPregunta) {
		preguntaActual = unaPregunta;
	}
	
	protected void borrarUltimaContestacion() {
		contestaciones.pop();
	}
	
}
