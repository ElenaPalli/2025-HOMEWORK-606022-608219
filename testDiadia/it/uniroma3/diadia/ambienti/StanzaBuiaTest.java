package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	private Stanza stanzaBuia;
	private Attrezzo lanterna;

	@BeforeEach
	void setUp() throws Exception {
		this.stanzaBuia = new StanzaBuia("stanza buia", "lanterna");
		this.lanterna = new Attrezzo("lanterna", 2);
	}

	@Test
	void testGetDescrizione() {
		
		assertEquals("Qui c'è buio pesto", this.stanzaBuia.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneConAttrezzoNecessario() {
		
		assertEquals("Qui c'è buio pesto", this.stanzaBuia.getDescrizione());
		this.stanzaBuia.addAttrezzo(this.lanterna);
		assertTrue(this.stanzaBuia.hasAttrezzo("lanterna"));
		assertNotEquals("Qui c'è buio pesto", this.stanzaBuia.getDescrizione());
	}


}
