import java.util.*;
import exceptions.*;

import java.text.*;


public class Main {	
	public static void main(String[] args)  throws CateringException{
		System.out.println("Benvenuto in Catering 3.0!");
		Catering catering=new Catering();
		
		int opzione;
		boolean exit = false;
		Scanner s = new Scanner(System.in);
		String nome;
		String cognome;
		String choice;
		String cf;
		String piva;
		int idmenu;
		Date data = null;
		String luogo;
		int invitati;
		int ms;
		int nav;
		String an;
		String st;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		
		
		
		catering.nuovoCliente("Biagio", "Fornitto", "X001");
		catering.nuovoCliente("Emanuele", "Bonaventura", "X002");
		catering.nuovoCliente("Matteo", "Bonaccorso", "X003");
		catering.nuovoCliente("Mario", "MariaMario", "X004");
		catering.nuovoCliente("Giulio", "Cesare", "X005");
		catering.nuovoCliente("Aldo", "Baglio", "X006");
		catering.nuovoCliente("Giacomo", "Poretti", "X007");
		catering.nuovoCliente("Giovanni", "Storti", "X008");
		catering.nuovoCliente("Anna", "Pannocchia", "X009");
		
		
		catering.nuovoRistorante("X001","Etrusca");
		catering.nuovoRistorante("X002","EtnaGarden");
		catering.nuovoRistorante("X003","Palio");
		
	
		
		
		
		catering.nuovoMenu("X001",1,"MenuDellaCasa");
		catering.nuovoMenu("X001",2,"MenuDiBiagio");
		
		
		
		catering.nuovoMenu("X002",1,"MenuDiEmanuele");
		catering.nuovoMenu("X002",2,"MenuDiMatteo");
		
		
		catering.nuovoMenu("X003",1,"MenuDiGino");
		catering.nuovoMenu("X003",2,"MenuDiLuca");
		
		
		catering.nuovaPortata("X001",1,1,"pasta",3.50);
		catering.nuovaPortata("X001",1,2,"broccoli",2.50);
		catering.nuovaPortata("X001",2,1,"pescespada",20);
		catering.nuovaPortata("X001",2,2,"salmone",15);
		
		
		catering.nuovaPortata("X002",1,1,"matriciana",5.50);
		catering.nuovaPortata("X002",1,2,"cavoli",4.50);
		catering.nuovaPortata("X002",2,1,"gamberetti",20);
		catering.nuovaPortata("X002",2,2,"seppia",15);
		
		
		catering.nuovaPortata("X003",1,1,"carbonara",5.50);
		catering.nuovaPortata("X003",1,2,"spinaci",4.50);
		catering.nuovaPortata("X003",2,1,"bistecca",5);
		catering.nuovaPortata("X003",2,2,"insalata",3);
		
		
		/*la questione adesso per quanto riguarda i servizi base e i servizi aggiuntivi è: posso crearli così,
		 * scavalcando la classe controller?? oppure qualche pattern può venirci in aiuto? Noi non abbiamo definito
		 * casi d'uso per quanto riguarda la creazione dei servizi ma qualcuno li deve creare però */
		/*Navetta n=new Navetta("50posti",50,500);
		catering.getSa().getListNavetta().add(n);*/
		
		/*System.out.println(catering.ricercaRistorante("X002").ricercaMenu(2).getPrezzoMenu());*/
		
		/*alla fine ho messo i costruttori nei servizibase e in quelli aggiuntivi,cosi non scavalchiamo il controller */
		
		catering.getSb().nuovoModoS(0, "bouffet",1);  				
		catering.getSb().nuovoModoS(1,"serviziodisala",3);
		catering.getSb().nuovoServizioT("Base",2);
		catering.getSb().nuovoServizioT("Medio",5);
		catering.getSb().nuovoServizioT("Regale",7);
		
		catering.getSa().nuovaNavetta("50posti",50,500);
		catering.getSa().nuovaNavetta("100posti",100,750);
		catering.getSa().nuovaAn("Silver",200);
		catering.getSa().nuovaAn("Gold", 400);
		catering.getSa().nuovaAn("Platinum",600);
		
	
		
		
		while(!exit) {
			System.out.println("Seleziona azione: ");
			System.out.println("1. Inserisci Cliente ");
			System.out.println("2. Inserisci Ristorante ");
			System.out.println("3. Inserisci Prenotazione ");
			System.out.println("4. Esci ");
			/*System.out.println("5 Visualizza clienti");*/
			System.out.println(">> ");
			opzione =Integer.parseInt(s.nextLine());
			
		
			switch(opzione) {
			case 1:
				System.out.println("Inserisci i dati del cliente.");
				System.out.println("Nome: ");
				nome= s.nextLine();
				System.out.println("Cognome: ");
				cognome = s.nextLine();
				System.out.println("CF: ");
				cf =s.nextLine();
				
				
				
				try {
					catering.nuovoCliente(nome, cognome, cf);
					System.out.println(catering.ricercaCliente(cf).toString());
				} catch (CateringException e) {
					System.out.println(e.getName());
				}
				break;
			
			case 2:
				System.out.println("Inserisci i dati del ristorante.");
				System.out.println("Piva: ");
				piva = s.nextLine();
				System.out.println("Nome: ");
				nome = s.nextLine();
				
				try {
					catering.nuovoRistorante(piva,nome);
					/*System.out.println(catering.ricercaRistorante(piva).toString());*/
				} catch (CateringException e) {
					System.out.println(e.getName());
				}
				break;	
			
			case 3:
				catering.nuovaPrenotazione();
				System.out.println("Inserisci PIVA del ristorante.");
				piva=s.nextLine();
				System.out.println("Inserisci id del Menu'.");
				idmenu=Integer.parseInt(s.nextLine());
				
				try {
				catering.inserisciMenuRistorante(piva,idmenu);
				} catch (CateringException e) {
					   System.out.println(e.getName());
					   break;
				}
				
				System.out.println("Inserisci data,luogo e invitati del catering." );
				
				System.out.println("Data: gg-mm-yyyy");
				try {
				data=sdf.parse(s.nextLine());
				} catch (ParseException e) {
				   System.out.println("Data malformata o inesistente");
				   break;
				}
				System.out.println("Luogo: ");
				luogo=s.nextLine();
				System.out.println("N° invitati: ");
				invitati=Integer.parseInt(s.nextLine());
				
				catering.inserisciLuogoCatering(luogo, data, invitati);
				
				System.out.println("Scegli il servizio (0 per bouffet, 1 per servizio di sala");
				ms=Integer.parseInt(s.nextLine());
				System.out.println("Scegli il servizio tavola (Base,Medio,Regale)");
				st=s.nextLine();
				
				catering.inserisciTipoServizio(st, ms);
				
				System.out.println("Desideri i servizi aggiuntivi (navetta e animazione) ? s/n");
				choice=s.nextLine();
				if (choice.equals("s")) {
					System.out.println("Posti navetta : (50,100)");
					nav=Integer.parseInt(s.nextLine());
					System.out.println("Pacchetto Animazione : (Silver,Gold,Platinum)");
					an=s.nextLine();
					catering.aggiungiPack(nav, an);
					
					
						
				}
				System.out.println("Inserisci il codice fiscale del cliente");
				cf=s.nextLine()	;
				
				try {
					
				catering.associaCliente(cf);
				System.out.println(catering.ricercaCliente(cf).toString());
				
				} catch (CateringException e) {
					System.out.println(e.getName());
					break;
				}
				
				System.out.println("Vuoi confermare l'inserimento del catering ? s/n");
				choice=s.nextLine();
				if (choice.equals("s")) {
					
					catering.confermaCatering();
					System.out.println("Catering inserito con successo");	
				}
				else
					System.out.println("Inserimento catering annullato");
				break;
				
			case 4:
				exit = true;
				break;
			/*case 5:
				
				System.out.println(catering.getListaClienti().toString());
				break;*/
			default:
				System.out.println("Comando Sconosciuto");
				break;
			
			
			
			
			
			}
			
			
		
		
		}
		
		s.close();
		
				
		
		
		
	}
	
}