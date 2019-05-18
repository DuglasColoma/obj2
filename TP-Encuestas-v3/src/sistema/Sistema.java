package sistema;

import java.util.HashSet;
import java.util.Set;

import investigador.Investigador;

public class Sistema {
	private Set<Investigador> investigadores;
	
	public Sistema() {
		investigadores = new HashSet<Investigador>();
	}
	
	public Set<Investigador> investigadores() {
		return investigadores;
	}
	
	public void registrarInvestigador(Investigador nuevoInvestigador) {
		investigadores.add(nuevoInvestigador);
	}
}