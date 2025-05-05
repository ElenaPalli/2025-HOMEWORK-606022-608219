package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	private String nome;
	private String parametro;
	
	public ComandoNonValido() {
		this.nome = "comando non valido";
	}
	
	@Override
	public void esegui(Partita partita) {
		partita.getConsole().mostraMessaggio(this.nome);
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public String getNome() {	
		return this.nome;
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}

}
