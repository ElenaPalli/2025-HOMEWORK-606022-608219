package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

		private Stanza stanzaBloccata;
		private Attrezzo chiave;
		private Stanza stanzaAdiacente;
		
	@BeforeEach
	void setUp() throws Exception {
		this.stanzaBloccata = new StanzaBloccata("bloccata", "nord", "chiave");
		this.chiave = new Attrezzo("chiave", 1);
		this.stanzaAdiacente = new Stanza("n11");
	}

	@Test
	void testGetDescrizione() {		
		assertEquals("Questa stanza è bloccata, per "
				+ "sbloccare la direzione" + "nord" + "posa un oggetto" + "chiave", this.stanzaBloccata.getDescrizione());
	}
	
    @Test
    void testGetStanzaAdiacenteDirezioneNonEsistente() {
        assertNull(this.stanzaBloccata.getStanzaAdiacente("sud"));
    }

    @Test
    void testImpostaStanzaAdiacenteDirezioneBloccata() {
        this.stanzaBloccata.impostaStanzaAdiacente("nord", this.stanzaAdiacente);
        assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"));
    }
    
    @Test
    void testImpostaStanzaAdiacenteDirezioneNonBloccata() {
        this.stanzaBloccata.impostaStanzaAdiacente("sud", this.stanzaAdiacente);
        assertEquals(this.stanzaAdiacente, this.stanzaBloccata.getStanzaAdiacente("sud"));
    }
    
	@Test
    void testGetStanzaAdiacenteDirezioneBloccataConAttrezzoNecessario() {    	
    	 this.stanzaBloccata.impostaStanzaAdiacente("nord", this.stanzaAdiacente);
    	 assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"));
    	 this.stanzaBloccata.addAttrezzo(this.chiave);
    	 assertEquals(this.stanzaAdiacente, this.stanzaBloccata.getStanzaAdiacente("nord"));
    }
}
