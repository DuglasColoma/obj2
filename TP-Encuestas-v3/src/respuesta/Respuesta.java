package respuesta;

import java.util.Arrays;
import java.util.List;

import opcion.Opcion;

public class Respuesta {
	
	// Factory methods
	public static Respuesta conUnaSolaOpcion(Opcion opcionElegida) {
		return new Respuesta(Arrays.asList(opcionElegida));
	}
	
	public static Respuesta conVariasOpciones(List<Opcion> opcionesElegidas) {
		return new Respuesta(opcionesElegidas);
	}
	
	private List<Opcion> opcionesElegidas;
	
	// Constructor
	protected Respuesta(List<Opcion> opcionesElegidas) {
		this.opcionesElegidas = opcionesElegidas;
	}

	// Testing
	public boolean      tieneUnaSolaOpcion() { return cantidadDeOpcionesElegidas() == 1; }

	// Queries
	public List<Opcion> opcionesElegidas()           { return opcionesElegidas; }
	public Opcion       primerOpcion()               { return opcionesElegidas().get(0); }
	
	
	/* PROTECTED */
	protected int cantidadDeOpcionesElegidas() { return opcionesElegidas().size(); }

}
