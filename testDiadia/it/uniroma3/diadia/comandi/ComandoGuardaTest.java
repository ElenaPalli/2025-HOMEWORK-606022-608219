package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoGuardaTest {
	private Comando comando;
	private String parametro;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.comando = new ComandoGuarda();
		this.parametro = "qualunque";
	}

	@Test
	void testGetNome() {
		assertEquals("guarda", comando.getNome());
	}
	
	@Test
	void testGetParametro() {
		assertNull(comando.getParametro());
		comando.setParametro(this.parametro);
		assertEquals(this.parametro, comando.getParametro());
	}
}
