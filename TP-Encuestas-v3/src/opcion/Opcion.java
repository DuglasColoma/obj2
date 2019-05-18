package opcion;

public class Opcion {
	
	private String textoDescriptivo;

	public Opcion(String textoDescriptivo) {
		this.textoDescriptivo = textoDescriptivo;
	}
	
	// Testing
	public boolean equals(Object object) {
		Opcion otraOpcion  = (Opcion) object;
		return textoDescriptivo().equals(otraOpcion.textoDescriptivo());
	}

	// Queries
	public String textoDescriptivo() {
		return textoDescriptivo;
	}
	
}
