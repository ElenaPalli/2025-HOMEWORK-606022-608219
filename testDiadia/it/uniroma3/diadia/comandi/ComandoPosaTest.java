package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoPosaTest {
	private Comando comando;
	private String nomeAttrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.comando = new ComandoPosa();
		this.nomeAttrezzo = "spada";
	}

	@Test
	void testGetNome() {
		assertEquals("posa", comando.getNome());
	}
	
	@Test
	void testGetParametro() {
		assertNull(comando.getParametro());
		comando.setParametro(this.nomeAttrezzo);
		assertEquals(this.nomeAttrezzo, comando.getParametro());
	}

}
