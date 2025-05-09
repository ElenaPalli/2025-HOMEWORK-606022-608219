package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandi fabbrica;

	
	@BeforeEach
	void setUp() throws Exception {
		
		this.fabbrica = new FabbricaDiComandiFisarmonica();
	}

	@Test
	void testCostruisciComandoNonValido() {
		assertEquals("comando non valido", fabbrica.costruisciComando(null).getNome());
	}

	@Test
	void testCostruisciComandoNonValidoConParolaSconosciuta() {
		assertEquals("comando non valido", fabbrica.costruisciComando("comandosbagliato").getNome());
	}
	
	

	@Test
	void testCostruisciComandoVai() {
		Comando c = fabbrica.costruisciComando("vai");
		assertEquals("vai", c.getNome());
		assertNull(c.getParametro());
	}

	@Test
	void testCostruisciComandoVaiConParametro() {
		Comando c = fabbrica.costruisciComando("vai nord");
		assertEquals("vai", c.getNome());
		assertEquals("nord", c.getParametro());
	}

	@Test
	void testCostruisciComandoPrendi() {
		Comando c = fabbrica.costruisciComando("prendi");
		assertEquals("prendi", c.getNome());
		assertNull(c.getParametro());
	}

	@Test
	void testCostruisciComandoPrendiConParametro() {
		Comando c = fabbrica.costruisciComando("prendi spada");
		assertEquals("prendi", c.getNome());
		assertEquals("spada", c.getParametro());
	}

	@Test
	void testCostruisciComandoPosa() {
		Comando c = fabbrica.costruisciComando("posa");
		assertEquals("posa", c.getNome());
		assertNull(c.getParametro());
	}

	@Test
	void testCostruisciComandoPosaConParametro() {
		Comando c = fabbrica.costruisciComando("posa spada");
		assertEquals("posa", c.getNome());
		assertEquals("spada", c.getParametro());
	}

	@Test
	void testCostruisciComandoAiuto() {
		Comando c = fabbrica.costruisciComando("aiuto");
		assertEquals("aiuto", c.getNome());
		assertNull(c.getParametro());
	}

	@Test
	void testCostruisciComandoAiutoConParametro() {
		Comando c = fabbrica.costruisciComando("aiuto extra");
		assertEquals("aiuto", c.getNome());
		assertEquals("extra", c.getParametro());
	}

	@Test
	void testCostruisciComandoFine() {
		Comando c = fabbrica.costruisciComando("fine");
		assertEquals("fine", c.getNome());
		assertNull(c.getParametro());
	}

	@Test
	void testCostruisciComandoFineConParametro() {
		Comando c = fabbrica.costruisciComando("fine gioco");
		assertEquals("fine", c.getNome());
		assertEquals("gioco", c.getParametro());
	}

	@Test
	void testCostruisciComandoGuarda() {
		Comando c = fabbrica.costruisciComando("guarda");
		assertEquals("guarda", c.getNome());
		assertNull(c.getParametro());
	}

	@Test
	void testCostruisciComandoGuardaConParametro() {
		Comando c = fabbrica.costruisciComando("guarda stanza");
		assertEquals("guarda", c.getNome());
		assertEquals("stanza", c.getParametro());
	}
	
	

	
}
