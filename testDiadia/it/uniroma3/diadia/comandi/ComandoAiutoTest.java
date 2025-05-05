package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoAiutoTest {
	private Comando comando;
	private String parametro;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.comando = new ComandoAiuto();
		this.parametro = "qualunque";
	}

	@Test
	void testGetNome() {
		assertEquals("aiuto", comando.getNome());
	}
	
	@Test
	void testGetParametro() {
		assertNull(comando.getParametro());
		comando.setParametro(parametro);
		assertEquals(this.parametro, comando.getParametro());
	}
}
