package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoFineTest {
	private Comando comando;
	private String parametro;
	
	@BeforeEach
	void setUp() throws Exception {
		
		this.comando = new ComandoFine();
		this.parametro = "qualunque";
	}

	@Test
	void testGetNome() {
		assertEquals("fine", comando.getNome());
	}
	
	@Test
	void testGetParametro() {
		assertNull(comando.getParametro());
		comando.setParametro(parametro);
		assertEquals(this.parametro, comando.getParametro());
	}

}
