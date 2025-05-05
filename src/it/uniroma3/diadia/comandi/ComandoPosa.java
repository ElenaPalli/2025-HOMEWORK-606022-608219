package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private String nomeAttrezzo;
	private String nome;

	public ComandoPosa() {
		this.nome = "posa";
	}

	/**
	 * Comando "posa"
	 * 
	 */
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			partita.getConsole().mostraMessaggio("Che attrezzo vuoi posare ?");
			nomeAttrezzo = partita.getConsole().leggiRiga();
		}

		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(a == null) {
			partita.getConsole().mostraMessaggio("L'attrezzo non è presente nella borsa!");
			return;
		}

		partita.getGiocatore().posa(a);
		partita.getStanzaCorrente().addAttrezzo(a);

		partita.getConsole().mostraMessaggio("Hai posato l'attrezzo: "+ a.toString());
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
