package opcion;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import opcion.Opcion;

class OpcionTest {
	
	@Test
	void tiene_un_texto_que_la_describe() {
		Opcion opcion = new Opcion(texto1());
		assertEquals(texto1(), opcion.textoDescriptivo());
	}
	
	@Test
	void es_igual_a_otra_si_tiene_el_mismo_texto_descriptivo() {
		assertEquals(
			new Opcion(texto1()),
			new Opcion(texto1()));
	}
	
	@Test
	void es_distinta_a_otra_si_tiene_distinto_texto_descriptivo() {
		assertNotEquals(
			new Opcion(texto1()),
			new Opcion(texto2()));
	}
	
	protected String texto1() {	return "aaa"; }
	protected String texto2() {	return "bbb"; }

}
