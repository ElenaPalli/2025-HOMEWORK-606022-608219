package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	
	public Labirinto() {
		this.creaStanze();
	}
	
	/**
     * Crea tutte le stanze e le porte di collegamento
     */
    public void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		Stanza stanzaMagica = new StanzaMagica("Stanza magica");
		Stanza stanzaBuia = new StanzaBuia("Stanza buia", "lanterna");
		Stanza stanzaBloccata = new StanzaBloccata("Stanza buia", "nord", "osso");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		
		/*nuove stanze*/
		aulaN11.impostaStanzaAdiacente("nord", stanzaMagica);
		stanzaMagica.impostaStanzaAdiacente("nord", stanzaBuia);
		stanzaBuia.impostaStanzaAdiacente("nord", stanzaBloccata);
		stanzaBloccata.impostaStanzaAdiacente("nord", atrio);
			
		
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
    }
   
    public void setStanzaVincente(Stanza stanzaVincente) {
    	this.stanzaVincente = stanzaVincente;
    }
	
    public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}
}
