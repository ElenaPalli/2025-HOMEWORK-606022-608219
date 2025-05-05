package it.uniroma3.diadia.attrezzi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AttrezzoTest {
	
	private Attrezzo spada;
	
	@BeforeEach
	void setUp() throws Exception {
		this.spada = new Attrezzo("spada", 5);
	}

	@Test
	void testGetNome() {
		assertEquals("spada", spada.getNome());
	}

	@Test
	void testGetPeso() {
		assertEquals(5, spada.getPeso());
	}
}
