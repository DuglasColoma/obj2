package proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import cuestionario.Cuestionario;

class ProyectoTest {
	
	@Test
	void posee_una_descriptcion() {
		Proyecto proyecto = new Proyecto(textoConDescripcion(), textoConProposito(), cuestionarios());
		
		assertEquals(textoConDescripcion(), proyecto.descripcion());
	}
	
	@Test
	void conoce_su_proposito() {
		Proyecto proyecto = new Proyecto(textoConDescripcion(), textoConProposito(), cuestionarios());
		
		assertEquals(textoConProposito(), proyecto.proposito());
	}
	
	@Test
	void puedo_pedirle_sus_cuestionarios() {
		List<Cuestionario> cuestionarios = cuestionarios();
		
		Proyecto proyecto = new Proyecto(textoConDescripcion(), textoConProposito(), cuestionarios);
		
		assertEquals(cuestionarios, proyecto.cuestionarios());
	}
	

	///////////////////////////////////////////////
	protected String textoConDescripcion() {
		return "Descripcion";
	}
	
	private String textoConProposito() {
		return "proposito";
	}
	
	protected List<Cuestionario> cuestionarios() {
		return Arrays.asList(
			nuevoCuestionario(),
			nuevoCuestionario());
	}
	
	protected Cuestionario nuevoCuestionario() {
		return mock(Cuestionario.class);
	}
	
}
