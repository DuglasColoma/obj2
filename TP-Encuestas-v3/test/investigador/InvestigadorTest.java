package investigador;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import proyecto.Proyecto;

class InvestigadorTest {
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	
	private Investigador unInvestigador;
	
	@BeforeEach
	void setUp() {
		proyecto1 = nuevoProyecto();
		proyecto2 = nuevoProyecto();
		
		unInvestigador = new Investigador();
	}

	@Test
	void un_nuevo_investigador_no_tiene_ningun_proyecto() {
		assertTrue(unInvestigador.proyectos().isEmpty());
	}

	@Test
	void puede_registrar_un_nuevo_proyectos() {
		unInvestigador.registrarProyecto(proyecto1);
		
		assertEquals(1, unInvestigador.proyectos().size());
		assertTrue(unInvestigador.proyectos().contains(proyecto1));
	}
	
	@Test
	void puede_registrar_varios_proyectos() {
		Set<Proyecto> proyectos = new HashSet<Proyecto>();
		proyectos.add(proyecto1);
		proyectos.add(proyecto2);
		
		unInvestigador.registrarProyectos(proyectos);
		
		assertEquals(proyectos, unInvestigador.proyectos());
		
	}


	///////////////////////
	private Proyecto nuevoProyecto() {
		return mock(Proyecto.class);
	}
	
}