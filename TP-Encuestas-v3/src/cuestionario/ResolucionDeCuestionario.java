package cuestionario;

import java.util.Stack;

public class ResolucionDeCuestionario {
	
	private Stack<EntradaDeCuestionario> entradas;

	public ResolucionDeCuestionario() {
		this.entradas = new Stack<EntradaDeCuestionario>();
	}
	
	public Stack<EntradaDeCuestionario> contestaciones() {
		return this.entradas;
	}

	public void registrar(EntradaDeCuestionario entradaCuestionario) {
		this.entradas.push(entradaCuestionario);
	}

	public void eliminarUltimaEntrada() {
		this.entradas.pop();
	}

}
