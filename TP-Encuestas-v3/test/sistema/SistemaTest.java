package sistema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import investigador.Investigador;


class SistemaTest {
	private Investigador investigador1;
	private Investigador investigador2;
	
	private Sistema sistema;
	
	@BeforeEach 
	void setUp() {
		investigador1 = nuevoInvestigador();
		investigador2 = nuevoInvestigador();
		sistema       = new Sistema();
	}

	@Test
	void un_sistema_nuevo_no_tiene_ningun_investigador_registrado() {
		assertTrue(sistema.investigadores().isEmpty());
	}
	
	@Test
	void puede_registrar_nuevos_investigadores() {
		sistema.registrarInvestigador(investigador1);
		sistema.registrarInvestigador(investigador2);
		
		assertEquals(2, sistema.investigadores().size());
		assertTrue(sistema.investigadores().contains(investigador1));
		assertTrue(sistema.investigadores().contains(investigador2));
	}
	
	/////////////////////////////////
	private Investigador nuevoInvestigador() {
		return mock(Investigador.class);
	}
	
}