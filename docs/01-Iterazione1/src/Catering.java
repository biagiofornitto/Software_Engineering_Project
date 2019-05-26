import java.util.*;


public class Catering {

	
	
	private List<Ristorante> listaRistoranti;
	private List<Cliente> listaClienti;
	private List<Prenotazione> listaPrenotazioni;
	private Prenotazione p;
	
	public Cliente ricercaCliente(String cf) {
		Iterator<Cliente> iterator = listaClienti.iterator();
		while (iterator.hasNext()) {
			Cliente c = iterator.next();
			if (c.getCodiceFiscale()==cf)
				return c;
		}
		return null;
	}
	
	public Cliente ricercaCliente(String nome, String cognome) {
		Iterator<Cliente> iterator = listaClienti.iterator();
		while (iterator.hasNext()) {
			Cliente c = iterator.next();
			if (c.getNome()==nome && c.getCognome()==cognome)
				return c;
		}
		return null;
	}
	
	

	
	public Catering() {
		
		this.listaRistoranti = new ArrayList<Ristorante>();  
		this.listaClienti = new ArrayList<Cliente>();  
		this.listaPrenotazioni = new ArrayList<Prenotazione>();  
	}



	public List<Ristorante> getListaRistoranti() {
		return listaRistoranti;
	}



	public List<Cliente> getListaClienti() {
		return listaClienti;
	}



	public List<Prenotazione> getListaPrenotazioni() {
		return listaPrenotazioni;
	}
	
	
	
	public void NuovoCliente( String nome, String cognome, String codiceFiscale) {
		Cliente c = new Cliente(nome,cognome,codiceFiscale);
		listaClienti.add(c);
	}
	
	public void EliminaCliente(String cf) {
		Cliente c = ricercaCliente(cf);
		if(confermaEliminaCliente())
			listaClienti.remove(c);
		
	}
	
	private boolean confermaEliminaCliente() {
		/*Qui va scritta la procedura di sicurezza
		 * relativa alla conferma di eliminazione
		 * ad esempio: una stringa in cui si chiede
		 * all'utente e si riceve un input
		 */
		return true;
	}
	
	
	public void NuovaPrenotazione(String luogo, Date data, int invitati) {
		
		p = new Prenotazione(luogo,  data,invitati);
		
	}
	
	
	
	public Prenotazione getP() {
		return p;
	}


	public void  ConfermaCatering(Prenotazione p) {
		
		listaPrenotazioni.add(p);
	}
	
}
	
	
	
