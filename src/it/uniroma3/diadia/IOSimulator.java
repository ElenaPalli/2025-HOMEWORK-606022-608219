package it.uniroma3.diadia;

public class IOSimulator implements IO{
	
	private String[] righeDaLeggere;
	private String[] messaggiStampati;
	private int indiceLettura;
	private int indiceStampa;
	
	public IOSimulator(String[] istruzioni) {
		this.righeDaLeggere = istruzioni;
		this.messaggiStampati = new String[istruzioni.length + 50];
		this.indiceLettura = 0;
		this.indiceStampa = 0;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		if(this.indiceStampa < this.messaggiStampati.length) {
			this.messaggiStampati[indiceStampa] = messaggio;
			this.indiceStampa++;
		}
		else {
			System.out.println("Impossibile salvare ulteriori messaggi, dimensione max raggiunta");
		}	
	}

	@Override
	public String leggiRiga() {
		if(indiceLettura < righeDaLeggere.length) {
			String riga = righeDaLeggere[indiceLettura];
			indiceLettura++;
			
			return riga;
		}
		else {
			return "fine";	// ritorna il messaggio di fine (che comporta l'esecuzione di un comandoFine)
		}
		
	}
	
	public void getMessaggiStampati() {
		System.out.println("\n\nStampa di tutti i messaggi ricevuti:\n");
		
		for(int i = 0; i <this.indiceStampa; i++) {
			System.out.println(this.messaggiStampati[i]);
		}
		
	}
	
}
