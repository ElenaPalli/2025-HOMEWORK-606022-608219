package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	private Borsa borsa;
	private Attrezzo spada;

	@BeforeEach
	void setUp() throws Exception {
		this.borsa = new Borsa();
		this.spada = new Attrezzo("spada",10);
	}

	@Test
	void testDefaultPesoMax() {
		assertEquals(this.borsa.getPesoMax(), 10);
	}

	@Test
	void testHasAttrezzoNonPresenteEPoiPresente() {
		assertFalse(this.borsa.hasAttrezzo("spada"));
		this.borsa.addAttrezzo(this.spada);
		assertTrue(this.borsa.hasAttrezzo("spada"));
	}

	@Test
	void testGetAttrezzoBorsaVuota() {
		assertNull(this.borsa.getAttrezzo("spada"));	
	}

	@Test
	void testGetAttrezzoNonEsistente() {
		assertNull(this.borsa.getAttrezzo("Martello"));
	}

	@Test
	void testGetAttrezzoPresenteNellaBorsa() {
		this.borsa.addAttrezzo(this.spada);
		assertEquals(this.borsa.getAttrezzo("spada"), this.spada);
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(this.spada));
	}

	@Test
	void testAddAttrezzoSuperaPesoMassimo() {
		this.borsa.addAttrezzo(this.spada);
		assertFalse(this.borsa.addAttrezzo(this.spada));
	}

	@Test
	void testAddAttrezzoRaggiuntoNumeroMassimo() {
		for (int i = 0; i < 10; i++) {
			assertTrue(this.borsa.addAttrezzo(new Attrezzo("Attrezzo" + i, 1)));
		}
		assertFalse(this.borsa.addAttrezzo(this.spada));
	}
	
	@Test
    void testGetPesoBorsaVuota() {
        assertEquals(0, borsa.getPeso());
    }
	
	@Test
	void testGetPeso() {
		this.borsa.addAttrezzo(this.spada);
		assertEquals(this.borsa.getPeso(), 10);
	}

	@Test
	void testIsEmptyBorsaVuota() {
		assertTrue(this.borsa.isEmpty());
		
	}
	@Test
    void testIsEmptyBorsaPiena() {
        this.borsa.addAttrezzo(this.spada);
		assertFalse(this.borsa.isEmpty());
	}	
	
	@Test
	void testRemoveAttrezzoBorsaVuota() {
		assertFalse(this.borsa.removeAttrezzo(this.spada));
	}

	@Test
	void testRemoveAttrezzoBorsaPienaEPoiVuota() {
		this.borsa.addAttrezzo(this.spada);
		assertTrue(this.borsa.removeAttrezzo(this.spada));
		assertTrue(this.borsa.isEmpty());
	}
}
