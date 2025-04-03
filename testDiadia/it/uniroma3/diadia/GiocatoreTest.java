package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {

	private Giocatore giocatore;
	private Attrezzo spada;
	private Attrezzo osso;

	@BeforeEach
	void setUp() throws Exception {
		this.giocatore = new Giocatore();
		this.spada = new Attrezzo("spada",7);
		this.osso = new Attrezzo("osso", 2);
	}

	@Test
	void testGetCfuValoreIniziale() {
		assertEquals(giocatore.getCfu(), 20);
	}

	@Test
	void testGetSetCfu() {
		this.giocatore.setCfu(5);
		assertEquals(this.giocatore.getCfu(), 5);
	}

	@Test
	void testGetSetBorsaNull() {
		assertNotNull(this.giocatore.getBorsa());
		this.giocatore.setBorsa(null);
		assertNull(this.giocatore.getBorsa());
	}

	@Test
	void testSetBorsaNuova() {
		Borsa nuovaBorsa = new Borsa();
		giocatore.setBorsa(nuovaBorsa);
		assertEquals(nuovaBorsa, giocatore.getBorsa());
	}

	@Test
	void testPrendiAttrezzoBorsaPiena() {
		for (int i = 0; i < 10; i++) {
			this.giocatore.prendi(new Attrezzo("Attrezzo" + i, 1));
		}
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("spada"));
	}

	@Test
	void testPrendiAttrezzoSuperaPesoMassimo() {
		this.giocatore.prendi(this.spada);
		this.giocatore.prendi(new Attrezzo("attrezzo", 5));
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("osso"));
	}

	@Test
	void testPrendiAttrezzo() {
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("spada"));
		this.giocatore.prendi(this.spada);
		assertTrue(this.giocatore.getBorsa().hasAttrezzo("spada"));
	}
	
	@Test
	void testPrendiAttrezziMultipli() {
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("spada"));
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("osso"));
		this.giocatore.prendi(this.spada);
		this.giocatore.prendi(this.osso);
		assertTrue(this.giocatore.getBorsa().hasAttrezzo("spada"));
		assertTrue(this.giocatore.getBorsa().hasAttrezzo("osso"));
	}

	@Test
	void testPrendiEPoiPosaAttrezzo() {
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("spada"));
		this.giocatore.prendi(this.spada);
		this.giocatore.posa(this.spada);
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("spada"));
	}

	@Test
	void testPrendiEPoiPosaAttrezziMultipli() {
		this.giocatore.prendi(this.spada);
		this.giocatore.prendi(this.osso);
		this.giocatore.posa(this.spada);
		this.giocatore.posa(this.osso);
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("spada"));
		assertFalse(this.giocatore.getBorsa().hasAttrezzo("scudo"));
	}
		
}
