package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {

	private Labirinto labirinto;
	private Stanza stanza;

	@BeforeEach
	void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.stanza = new Stanza("n11");
	}

	@Test
	void testStanzaInizialeDefault() {
		assertEquals("Atrio", this.labirinto.getStanzaIniziale().getNome());
	}

	@Test
	void testGetSetStanzaIniziale() {
		assertNotEquals(this.labirinto.getStanzaIniziale(), this.stanza);
		this.labirinto.setStanzaIniziale(this.stanza);
		assertEquals(this.labirinto.getStanzaIniziale(), this.stanza);
	}

	@Test
	void testSetStanzaInizialeNull() {
		this.labirinto.setStanzaIniziale(null);
		assertNull(this.labirinto.getStanzaIniziale());
	}

	@Test
	void testStanzaVincenteDefault() {
		assertEquals("Biblioteca", this.labirinto.getStanzaVincente().getNome());
	}

	@Test
	void testGetSetStanzaVincente() {
		assertNotEquals(this.labirinto.getStanzaVincente(), this.stanza);
		this.labirinto.setStanzaVincente(this.stanza);
		assertEquals(this.labirinto.getStanzaVincente(), this.stanza);
	}

	@Test
	void testSetStanzaVincenteNull() {
		this.labirinto.setStanzaVincente(null);
		assertNull(this.labirinto.getStanzaVincente());
	}
}
