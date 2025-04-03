package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {

	private Partita partita;
	private Stanza vincente;
	private Giocatore giocatore;
	private Labirinto labirinto;

	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
		this.vincente = new Stanza("biblioteca");
		this.giocatore = new Giocatore();
		this.labirinto = new Labirinto();
	}

	@Test
	void testPartitaVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}

	@Test
	void testPartitaPersaInStanzaNonVincente() {
		this.partita.setStanzaCorrente(new Stanza("n11"));
		assertFalse(this.partita.vinta());
	}

	@Test
	void testPartitaPersaPerCfuFiniti() {
		this.partita.getGiocatore().setCfu(0);		
		assertFalse(this.partita.vinta());
	}

	@Test
	void testPartitaNonFinitaEPoiFinita() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

	@Test
	void testSetStanzaCorrente() {
		assertNotEquals(this.partita.getStanzaCorrente(), this.vincente);
		this.partita.setStanzaCorrente(this.vincente);
		assertEquals(this.partita.getStanzaCorrente(), this.vincente);
	}

	@Test
	void testSetStanzaCorrenteNull() {
		this.partita.setStanzaCorrente(null);
		assertNull(this.partita.getStanzaCorrente());
	}

	@Test
	void testSetGiocatore() {
		assertNotEquals(this.partita.getGiocatore(), this.giocatore);
		this.partita.setGiocatore(this.giocatore);
		assertEquals(this.partita.getGiocatore(), this.giocatore);
	}
	
	@Test
	void testSetGiocatoreNull() {
	    this.partita.setGiocatore(null);
	    assertNull(this.partita.getGiocatore());
	}

	@Test
	void testSetLabirinto() {
		assertNotEquals(this.partita.getLabirinto(), this.labirinto);
		this.partita.setLabirinto(this.labirinto);
		assertEquals(this.partita.getLabirinto(), this.labirinto);
	}
	
	@Test
	void testSetLabirintoNull() {
	    this.partita.setLabirinto(null);
	    assertNull(this.partita.getLabirinto());
	}
}
