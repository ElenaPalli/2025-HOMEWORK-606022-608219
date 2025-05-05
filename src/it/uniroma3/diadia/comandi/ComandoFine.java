package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	private String nome;
	private String parametro;
	
	public ComandoFine() {
		this.nome = "fine";
	}
	
	/**
	 * Comando "Fine".
	 */
	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio("Grazie di aver giocato!");
		partita.setFinita();
		
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
		
	}
	@Override
	public String getParametro() {
		
		return this.parametro;
	}
	@Override
	public String getNome() {
		
		return this.nome;
	}

}
