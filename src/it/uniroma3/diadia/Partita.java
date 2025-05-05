package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	
	private Labirinto labirinto;
	private Giocatore giocatore;
	private Stanza stanzaCorrente;
	private IO console;

	
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.stanzaCorrente =this.labirinto.getStanzaIniziale();
		this.finita = false;
		this.giocatore = new Giocatore();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	/**
	 * Restituisce la stanza corrente.
	 * @return la stanza corrente
	 */	
	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}
	
	/**
	 * Restituisce il giocatore.
	 * @return il giocatore
	 */	
	
	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	
	/**
	 * Restituisce il labirinto.
	 * @return il il labirinto
	 */
	public Labirinto getLabirinto() {
		return labirinto;
	}

	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public void setConsole(IO c) {
		this.console = c;
	}
	public IO getConsole() {
		return this.console;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return this.finita || vinta() || (this.giocatore.getCfu() <= 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	/**
	 * Stampa il numero di cfu del giocatore
	 */
	public String toString(){
		return this.getStanzaCorrente()+"\nCfu = " + this.giocatore.getCfu();
	}
	
}
