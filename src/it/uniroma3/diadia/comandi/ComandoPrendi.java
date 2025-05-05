package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private String nome;
	private String nomeAttrezzo;
	
	public ComandoPrendi() {
		this.nome = "prendi";
	}
	
	/**
	 * Comando "prendi"
	 * 
	 */
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			partita.getConsole().mostraMessaggio("Che attrezzo vuoi prendere ?");
			nomeAttrezzo = partita.getConsole().leggiRiga();
		}
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);

		if(a == null) {
			partita.getConsole().mostraMessaggio("L'attrezzo non � presente nella stanza!");
			return;
		}

		partita.getGiocatore().prendi(a);
		partita.getStanzaCorrente().removeAttrezzo(a);

		partita.getConsole().mostraMessaggio("Hai preso l'attrezzo: "+ a.toString());

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
