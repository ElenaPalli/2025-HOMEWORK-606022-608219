package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoVaiTest {

	private Comando comando;
	private String direzione;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.comando = new ComandoVai();
		this.direzione = "nord";
	}

	@Test
	void testGetNome() {
		assertEquals("vai", comando.getNome());
	}
	
	@Test
	void testGetParametro() {
		assertNull(comando.getParametro());
		comando.setParametro(direzione);
		assertEquals(this.direzione, comando.getParametro());
	}

}
