import java.util.*;
import java.text.SimpleDateFormat;
import exceptions.*;


public class Catering {

	
	
	private List<Ristorante> listaRistoranti;
	private List<Cliente> listaClienti;
	private List<Prenotazione> listaPrenotazioni;
	private Prenotazione p;			/*istanza di prenotazione corrente*/
	private ServiziBase sb;       /* i servizi verranno riempiti con le rispettive liste nel main*/
	private ServiziAggiuntivi sa; 
	
	/*pattern singleton*/
	private static Catering instance;
	
	
	
	/*costruttore privato*/
	private Catering() {
		
		listaRistoranti = new ArrayList<Ristorante>();  
		listaClienti = new ArrayList<Cliente>();  
		listaPrenotazioni = new ArrayList<Prenotazione>(); 
		sb=new ServiziBase();								 /*costituito da due liste*/
		sa=new ServiziAggiuntivi(); 							/*costituito da due liste*/
	}

	/*metodo che mi restituisce instance*/
	public static Catering getInstance() {
		if (instance==null){
		/*System.err.println("Istanza creata");*/
		instance = new Catering();
		}
		return instance;
	
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
	public Cliente ricercaCliente(String cf) throws CateringException {
		if (cf.indexOf(' ')>-1 || cf.isEmpty()) throw new CateringException("Codice Fiscale non valido");
		Iterator<Cliente> iterator = listaClienti.iterator();
		while (iterator.hasNext()) {
			Cliente c = iterator.next();
			if (c.getCodiceFiscale().equals(cf)) {
				return c;
			}
		}
		return null;
	}
	
	public Cliente ricercaCliente(String nome, String cognome)throws CateringException {
		if (nome.indexOf(' ')>-1 || nome.isEmpty() || cognome.indexOf(' ')>-1 || cognome.isEmpty()) 
			throw new CateringException("Nome e/o cognome non validi\n");
		Iterator<Cliente> iterator = listaClienti.iterator();
		while (iterator.hasNext()) {
			Cliente c = iterator.next();
			if (c.getNome().equals(nome) && c.getCognome().equals(cognome))
				
				return c;
		}
		return null;
	}
	
	
	public Ristorante ricercaRistorante(String PIVA)throws CateringException {
		if (PIVA.indexOf(' ')>-1 || PIVA.isEmpty()) throw new CateringException("PIVA non valida");
		Iterator<Ristorante> iterator = listaRistoranti.iterator();
		while (iterator.hasNext()) {
			Ristorante r = iterator.next();
			if (r.getPIVA().equals(PIVA)) 
							return r;
				
		}
		return null;
	}
	
	


	
	
	
	public void nuovoCliente( String nome, String cognome, String codiceFiscale) throws CateringException{
		if (codiceFiscale.indexOf(' ')>-1 || codiceFiscale.isEmpty()) 
			throw new CateringException("Codice Fiscale non valido\n");
		if (nome.indexOf(' ')>-1 || nome.isEmpty() || cognome.indexOf(' ')>-1 || cognome.isEmpty()) 
			throw new CateringException("Nome e/o cognome non validi\n");		
		if (contieneCliente(codiceFiscale)) throw new CateringException("Codice fiscale del cliente già  presente\n");
		for(char c : nome.toCharArray()) {
			if (Character.isDigit(c))
				throw new CateringException("Nome non valido\n");
		}
		for(char c : cognome.toCharArray()) {
			if (Character.isDigit(c))
				throw new CateringException("Cognome non valido\n");
		}
		
		
		
		Cliente c = new Cliente(nome,cognome,codiceFiscale);
		this.listaClienti.add(c);
	}
	
	private boolean contieneCliente(String cf)throws CateringException{
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
				throw new CateringException("Codice fiscale del cliente già  presente\n");
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
		if (m==null) throw new CateringException("Menù non trovato\n");
		getP().setMenu(m);  /*dal menu posso risalire al ristorante se poi mi servisse*/
		
							/*nella prenotazione settiamo solo il menu*/
		
	}
	
	public void inserisciLuogoCatering(String luogo, Date data, int invitati)throws CateringException {
		getP().setLuogo(luogo);
		Date oggi=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		if (data.compareTo(oggi)<0) throw new CateringException("La data inserita non è valida...è già passata\n");
		getP().setData(data);
		getP().setInvitati(invitati);
		
	};
	
	
	/*servizi base: serviziotavola e modoservizio*/
	public void inserisciTipoServizio(String serviziotavola, int modoservizio) throws CateringException {
		
		ServizioTavola st=this.sb.getServizioT(serviziotavola);
		if (st==null ) throw new CateringException("Servizio tavola inesistente\n");
		ModoServizio ms=this.sb.getModoServizio(modoservizio);
		if (ms==null ) throw new CateringException("Modalità  di servizio inesistente\n");
		getP().setServiziBase(st, ms);
		
		
	};
	
	/*servizi aggiuntivi: animazione e navetta*/
	public void aggiungiPack(int postiNavetta, String animazione)throws CateringException {
		Navetta nav=this.sa.getNavetta(postiNavetta);
		if (nav==null ) throw new CateringException("Navetta inesistente\n");
		Animazione an=this.sa.getAnimazione(animazione);
		if (an==null ) throw new CateringException("Pacchetto animazione non presente\n");
		
		getP().setServiziAggiuntivi(an, nav);
		
		
	};
	
	

	public void  confermaCatering() {
		
		listaPrenotazioni.add(p);
		getP().incID();
	}
	
	public void associaCliente(String cf) throws CateringException{
		Cliente c = ricercaCliente(cf);
		if (c == null) 
			throw new CateringException("Cliente non trovato\n");
		getP().setCliente(c);

		
	}
	
	/*crud ristorante*/
	public void nuovoRistorante(String PIVA, String nome) throws CateringException{
		if (PIVA.indexOf(' ')>-1 || PIVA.isEmpty()) 
			throw new CateringException("PIVA non valida\n");
		if (nome.indexOf(' ')>-1 || nome.isEmpty()) 
			throw new CateringException("Nome non valido\n");		
		if (contieneRistorante(PIVA)) throw new CateringException("PIVA del ristorante già  presente\n");
		Ristorante risto=new Ristorante(PIVA,nome);
		listaRistoranti.add(risto);
	}
	
	private boolean contieneRistorante(String PIVA)throws CateringException{
		
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
				throw new CateringException("PIVA del Ristorante già  presente\n");
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
	
	/*aggiunta metodi iterazione 3*/
	
	public List<Prenotazione> ricercaCateringsCliente(String cf) throws CateringException {
		List <Prenotazione> listaP=new ArrayList<Prenotazione>();
		Cliente c = ricercaCliente(cf);
		if (c == null) 
			throw new CateringException("Cliente non trovato\n");
		Iterator<Prenotazione> iterator = listaPrenotazioni.iterator();
		while (iterator.hasNext()) {
			Prenotazione pr = iterator.next();
			if (pr.getCliente().getCodiceFiscale().equals(cf)) 
					listaP.add(pr);
			
		
		}
		if (listaP.isEmpty()) 
			throw new CateringException("Il Cliente selezionato non ha prenotazioni al momento\n");
		
		return listaP;
		
	}
	
	
	public List<Prenotazione> ricercaCateringsRistorante(String PIVA) throws CateringException {
		List <Prenotazione> listaP=new ArrayList<Prenotazione>();
		Ristorante r = ricercaRistorante(PIVA);
		if (r == null) 
			throw new CateringException("Ristorante non trovato\n");
		Iterator<Prenotazione> iterator = listaPrenotazioni.iterator();
		
		while (iterator.hasNext()) {
			Prenotazione pr = iterator.next();
			Iterator<Menu> iteratorM=r.getListaMenu().iterator();
			while(iteratorM.hasNext()) {
				Menu m=iteratorM.next();
				if (pr.getMenu().equals(m))
						listaP.add(pr);
			
			}
		}
		if (listaP.isEmpty()) {
			throw new CateringException("Il Ristorante selezionato non ha prenotazioni al momento\n");
		}
		return listaP;
		
	}
	
	
	public Fattura emettiFattura(String cf,int sconto,int id) throws CateringException {
		if (sconto<0) throw new CateringException("Sconto errato\n");
		Cliente c=ricercaCliente(cf);
		double totale =0;
		List<Prenotazione> lp=ricercaCateringsCliente(cf);
		/*controllo se l'id della prenotazione esiste tra le prenotazioni del cliente selezionato*/
		Iterator<Prenotazione> iterator = lp.iterator();
		while (iterator.hasNext()) {
			Prenotazione pr = iterator.next();
			if (pr.getID()==id) {
					totale=pr.getPreventivo().getPrezzoTotale();
					break;
			}
			
		}
		
		if (totale == 0) throw new CateringException("La prenotazione selezionata è inesistente per questo cliente");
		
		
		c.nuovaFattura(totale,sconto,id);
		c.getF().calcolaTotale();
		c.associaFattura();
		
		
		return c.getF();
		
	}
	
	
	




	
	
	
	
}