import java.util.*;

import exceptions.*;


public class Catering {

	
	
	private List<Ristorante> listaRistoranti;
	private List<Cliente> listaClienti;
	private List<Prenotazione> listaPrenotazioni;
	private Prenotazione p;			/*istanza di prenotazione corrente*/
	private ServiziBase sb;       /* i servizi verranno riempiti con le rispettive liste nel main*/
	private ServiziAggiuntivi sa; 
	
	
	
	
	/*costruttore*/
	public Catering() {
		
		listaRistoranti = new ArrayList<Ristorante>();  
		listaClienti = new ArrayList<Cliente>();  
		listaPrenotazioni = new ArrayList<Prenotazione>(); 
		sb=new ServiziBase();								 /*costituito da due liste*/
		sa=new ServiziAggiuntivi(); 							/*costituito da due liste*/
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
	
	
	
	
	
	public ServiziBase getSb() {
		return sb;
	}

	public ServiziAggiuntivi getSa() {
		return sa;
	}


	public Prenotazione getP() {
		return p;
	}
	
	
	




	/*funzioni di ricerca*/
	public Cliente ricercaCliente(String cf) {
		Iterator<Cliente> iterator = listaClienti.iterator();
		while (iterator.hasNext()) {
			Cliente c = iterator.next();
			if (c.getCodiceFiscale().equals(cf)) {
				return c;
			}
		}
		return null;
	}
	
	public Cliente ricercaCliente(String nome, String cognome) {
		Iterator<Cliente> iterator = listaClienti.iterator();
		while (iterator.hasNext()) {
			Cliente c = iterator.next();
			if (c.getNome().equals(nome) && c.getCognome().equals(cognome))
				
				return c;
		}
		return null;
	}
	
	
	public Ristorante ricercaRistorante(String PIVA) {
		Iterator<Ristorante> iterator = listaRistoranti.iterator();
		while (iterator.hasNext()) {
			Ristorante r = iterator.next();
			if (r.getPIVA().equals(PIVA)) 
							return r;
				
		}
		return null;
	}
	
	


	
	
	
	public void nuovoCliente( String nome, String cognome, String codiceFiscale) throws CateringException{
		if (contieneCliente(codiceFiscale)) throw new CateringException("Codice fiscale del cliente già presente\n");
		Cliente c = new Cliente(nome,cognome,codiceFiscale);
		this.listaClienti.add(c);
	}
	
	private boolean contieneCliente(String cf){
		return (ricercaCliente(cf)!=null);
	}
	
	
	
	
	
	public void aggiornaCliente(String cf, String nuovoValore, String campo) throws CateringException{
		Cliente c = ricercaCliente(cf);
		if (c == null) 
			throw new CateringException("Cliente non trovato\n");
		switch(campo) {
		case "nome":
			c.setNome(nuovoValore);
			break;
		case "cognome":
			c.setCognome(nuovoValore);
			break;
		case "cf":
			if (contieneCliente(nuovoValore)) 
				throw new CateringException("Codice fiscale del cliente gia' presente\n");
			c.setCodiceFiscale(nuovoValore);
			break;
		default:
			throw new CateringException("Campo inserito non valido\n");
		}
	}
	
	
	
	
	
	
	
	public void eliminaCliente(String cf) throws CateringException{
		if (contieneCliente(cf)==false) throw new CateringException("Cliente non trovato\n");
		Cliente c = ricercaCliente(cf);
		if(confermaEliminaCliente())
			listaClienti.remove(c);
		
	}
	
	private boolean confermaEliminaCliente() {
		System.out.println("Sei sicuro di voler eliminare il riferimento al cliente?\nLa scelta è irreversibile. (y/n)");
		Scanner input = new Scanner(System.in);
		return (input.nextLine()=="y");
	}
	
	
	/*public void NuovaPrenotazione(String luogo, Date data, int invitati) {
		
		p = new Prenotazione(luogo,data,invitati);
		
		/*abbiamo poi il metodo che inserisce luogo,data e invitati*/
	/*}*/
	
	
	public void nuovaPrenotazione() {
		
		p=new Prenotazione();
		
	}
	
	

	
	public void inserisciMenuRistorante(String PIVA,int menu) throws CateringException{
		Ristorante ris=ricercaRistorante(PIVA);
		if (ris==null) throw new CateringException("Ristorante non trovato\n");
		Menu m=ris.ricercaMenu(menu);
		if (m==null) throw new CateringException("Menu' non trovato\n");
		getP().setMenu(m);  /*dal menu posso risalire al ristorante se poi mi servisse*/
		
							/*nella prenotazione settiamo solo il menu*/
		
	}
	
	public void inserisciLuogoCatering(String luogo, Date data, int invitati) {
		getP().setLuogo(luogo);
		getP().setData(data);
		getP().setInvitati(invitati);
		
	};
	
	
	/*servizi base: serviziotavola e modoservizio*/
	public void inserisciTipoServizio(String serviziotavola, int modoservizio) {
		
		ServizioTavola st=this.sb.getServizioT(serviziotavola);
		ModoServizio ms=this.sb.getModoServizio(modoservizio);
		getP().setServiziBase(st, ms);
		
		
	};
	
	/*servizi aggiuntivi: animazione e navetta*/
	public void aggiungiPack(int postiNavetta, String animazione) {
		Navetta nav=this.sa.getNavetta(postiNavetta);
		Animazione an=this.sa.getAnimazione(animazione);
		
		getP().setServiziAggiuntivi(an, nav);
		
		
	};
	
	

	public void  confermaCatering() {
		
		listaPrenotazioni.add(p);
	}
	
	public void associaCliente(String cf) throws CateringException{
		Cliente c = ricercaCliente(cf);
		if (c == null) 
			throw new CateringException("Cliente non trovato\n");
		getP().setCliente(c);
		
		
	}
	
	/*crud ristorante*/
	public void nuovoRistorante(String PIVA, String nome) throws CateringException{
		if (contieneRistorante(PIVA)) throw new CateringException("PIVA del ristorante già presente\n");
		Ristorante risto=new Ristorante(PIVA,nome);
		listaRistoranti.add(risto);
	}
	
	private boolean contieneRistorante(String PIVA){
		return (ricercaRistorante(PIVA)!=null);
	}
	
	public void aggiornaRistorante(String PIVA, String nuovoValore, String campo) throws CateringException{
		Ristorante risto= ricercaRistorante(PIVA);
		if (risto == null) 
			throw new CateringException("Ristorante non trovato\n");
		switch(campo) {
		case "nome":
			risto.setNome(nuovoValore);
			break;
	
		case "PIVA":
			if (contieneRistorante(nuovoValore)) 
				throw new CateringException("PIVA del Ristorante gia' presente\n");
			risto.setPIVA(nuovoValore);
			break;
		default:
			throw new CateringException("Campo inserito non valido\n");
		}
	}
	
	
	
	public void eliminaRistorante(String PIVA) throws CateringException {
		Ristorante risto = ricercaRistorante(PIVA);
		if (risto==null)throw new CateringException("Ristorante non trovato\n");
		if(confermaEliminaRistorante())
			listaRistoranti.remove(risto);
		
	}
	public boolean confermaEliminaRistorante() {
		System.out.println("Sei sicuro di voler eliminare il riferimento al ristorante?\nLa scelta è irreversibile. (y/n)");
		Scanner input = new Scanner(System.in);
		return (input.nextLine()=="y");
		
	}
	

	public void nuovoMenu(String PIVA,int ID, String nome) throws CateringException{
		Ristorante risto=ricercaRistorante(PIVA);
		if (risto==null)throw new CateringException("Ristorante non trovato\n");
		risto.nuovoMenu(ID, nome);
	}
	
	
	public void eliminaMenu(String PIVA,int ID) throws CateringException {
		Ristorante risto=ricercaRistorante(PIVA);
		if (risto==null)throw new CateringException("Ristorante non trovato\n");
		risto.eliminaMenu(ID);
		
	}
	
	
	public void nuovaPortata(String PIVA,int IDmenu, int IDportata, String nome, double prezzo) throws CateringException{
		Ristorante risto=ricercaRistorante(PIVA);
		if (risto==null)throw new CateringException("Ristorante non trovato\n");
		Menu m=risto.ricercaMenu(IDmenu);
		if (m==null)throw new CateringException("Menu non trovato\n");
		m.nuovaPortata(IDportata, nome, prezzo);
	}
	
	
	public void eliminaPortata(String PIVA,int IDmenu, int IDportata) throws CateringException {
		Ristorante risto=ricercaRistorante(PIVA);
		if (risto==null)throw new CateringException("Ristorante non trovato\n");
		Menu m=risto.ricercaMenu(IDmenu);
		if (m==null)throw new CateringException("Menu non trovato\n");
		m.eliminaPortata(IDportata);
		
	}




	
	
	
	
}
	
	
	
