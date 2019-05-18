package proyecto;

import java.util.List;

import cuestionario.Cuestionario;

public class Proyecto {

	private String             textoConDescripcion;
	private String             proposito;
	private List<Cuestionario> cuestionarios;

	public Proyecto(String textoConDescripcion, String proposito, List<Cuestionario> cuestionarios) {
		this.textoConDescripcion = textoConDescripcion;
		this.proposito           = proposito;
		this.cuestionarios       = cuestionarios;
	}

	// Queries
	public String descripcion() {
		return textoConDescripcion;
	}
	
	public String proposito() {
		return proposito;
	}

	public List<Cuestionario> cuestionarios() {
		return cuestionarios;
	}

	
}
