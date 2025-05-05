package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public interface Comando {
	/**
	* esecuzione del comando
	*/
	public void esegui(Partita partita);

	/**
	* set parametro del comando
	*/
	public void setParametro(String parametro);
	
	public String getNome();
	
	public String getParametro();
}

/*


public class Comando {

    private String nome;
    private String parametro;

    public Comando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			this.nome = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();
    }

    public String getNome() {
        return this.nome;
    }

    public String getParametro() {
        return this.parametro;
    }

    public boolean sconosciuto() {
        return (this.nome == null);
    }
}
*/