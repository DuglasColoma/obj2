package investigador;

import java.util.HashSet;
import java.util.Set;

import proyecto.Proyecto;

public class Investigador {
	
	private Set<Proyecto> proyectos;
	
	public Investigador() {
		proyectos = new HashSet<Proyecto>();
	}
	
	// Queries
	public Set<Proyecto> proyectos() {
		return proyectos;
	}
	
	// Commands
	public void registrarProyecto(Proyecto nuevoProyecto) {
		proyectos.add(nuevoProyecto);
	}
	
	public void registrarProyectos(Set<Proyecto> nuevosProyectos) {
		nuevosProyectos.stream().forEach(this::registrarProyecto);
	}
	
}