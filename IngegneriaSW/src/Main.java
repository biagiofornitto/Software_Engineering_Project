import java.util.*;
import exceptions.*;

import java.text.*;


public class Main {	
	public static void main(String[] args)  throws CateringException{
		System.out.println("Benvenuto in Catering 3.0!");
		Catering catering= Catering.getInstance(); /*singleton*/
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
		List<Prenotazione> pr;
		Prenotazione p;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		int sconto;
		Fattura f;
		int id;
		
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
			System.out.println("4. Ricerca Caterings per Cliente ");
			System.out.println("5. Ricerca Caterings per Ristorante ");
			System.out.println("6. Emetti Fattura ");
			System.out.println("7. Esci ");
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
				
				boolean isSuccess = false;
				while(!isSuccess) {
					try {
						System.out.println("Inserisci PIVA del ristorante.");
						piva=s.nextLine();
						System.out.println("Inserisci ID del Menu'.");
						idmenu=Integer.parseInt(s.nextLine());
						
						catering.inserisciMenuRistorante(piva,idmenu);
						
						isSuccess = true;
					} catch (CateringException e) {
					   System.out.println(e.getName());	 
					   
					}
				}
				System.out.println("Inserisci data,luogo e invitati del catering." );
				isSuccess = false;
				while (!isSuccess) {
					try {
					
					
					System.out.println("Data: gg-mm-yyyy");
					data=sdf.parse(s.nextLine());
					
					isSuccess = true;
					} catch (ParseException e) {
					   System.out.println("Data malformata o inesistente \n");
					 
					}
				}
				
				System.out.println("Luogo: ");
				luogo=s.nextLine();
				System.out.println("N° invitati: ");
				invitati=Integer.parseInt(s.nextLine());
				
			
				
				try {
					catering.inserisciLuogoCatering(luogo, data, invitati);
					
				}catch(CateringException e) {
					System.out.println(e.getName());
					break;
				}
				
				isSuccess = false;
				while (!isSuccess) {
					try {
						System.out.println("Scegli il servizio (0 per bouffet, 1 per servizio di sala)");
						ms=Integer.parseInt(s.nextLine());
						System.out.println("Scegli il servizio tavola (Base,Medio,Regale)");
						st=s.nextLine();
					
						catering.inserisciTipoServizio(st, ms);
						
						isSuccess = true;
						
					}catch(CateringException e) {
						System.out.println(e.getName());
						
					}
				}
				System.out.println("Desideri i servizi aggiuntivi (navetta e animazione) ? S/N");
				choice=s.nextLine();
				if (choice.equals("S")) {
					
					isSuccess = false;
					while (!isSuccess) {
						try {
							System.out.println("Posti navetta : (50,100)");
							nav=Integer.parseInt(s.nextLine());
							System.out.println("Pacchetto Animazione : (Silver,Gold,Platinum)");
							an=s.nextLine();
							
							catering.aggiungiPack(nav, an);
							isSuccess = true;
						}catch(CateringException e) {
							System.out.println(e.getName());
							
						}
					}
					
					/*la factory si trova nella classe prenotazione*/
					catering.getP().setPrevfactory(new PreventivoExtraFactory());  /*set dell' abstractfactory per PreventivoExtra*/
					
						
							
				}
				else 
					catering.getP().setPrevfactory(new PreventivoFactory());	/*set dell'abstractfactory per Preventivo*/
				
				System.out.println("Desideri visualizzare il preventivo ? S/N");
				choice=s.nextLine();
				
				catering.getP().CalcolaPrev(); /*il preventivo viene istanziato e calcolato*/
				
				if (choice.equals("S"))
					System.out.println( catering.getP().getPreventivo().toString());
				
				isSuccess = false;
				while (!isSuccess) {
					try {
						System.out.println("Inserisci il codice fiscale del cliente");
						cf=s.nextLine()	;
						catering.associaCliente(cf);
						System.out.println(catering.ricercaCliente(cf).toString());
						isSuccess = true;
					} catch (CateringException e) {
						System.out.println(e.getName());
						
					}
				}
				System.out.println("Vuoi confermare l'inserimento del catering ? S/N");
				choice=s.nextLine();
				if (choice.equals("S")) {
					
					catering.confermaCatering();
					System.out.println("Catering inserito con successo");	
				}
				else
					System.out.println("Inserimento catering annullato");
				break;
			case 4:
					System.out.println("Inserisci il codice fiscale del cliente.");
					cf=s.nextLine();
					try {
					pr=catering.ricercaCateringsCliente(cf);
					System.out.println("Caterings del cliente: "+catering.ricercaCliente(cf).toString());
					Iterator<Prenotazione> iterator = pr.iterator();
					while (iterator.hasNext()) {
						p=iterator.next();
						System.out.println(p.toString());
					
					}
					
					}catch(CateringException e) {
						System.out.println(e.getName());
					}
					
					
				break;
				
			case 5:
				System.out.println("Inserisci la PIVA del ristorante.");
				piva=s.nextLine();
				try {
				pr=catering.ricercaCateringsRistorante(piva);
				System.out.println("Caterings del ristorante: "+catering.ricercaRistorante(piva).toString());
				Iterator<Prenotazione> iterator = pr.iterator();
				while (iterator.hasNext()) {
					p=iterator.next();
					System.out.println(p.toString());
				
				}
				}catch(CateringException e) {
				System.out.println(e.getName());
				}
					
				
				break;	
			case 6:
				System.out.println("Inserisci il codice fiscale del cliente per cui vuoi emettere la fattura");
				cf=s.nextLine();
				
				System.out.println("Inserisci id della prenotazione");
				id=Integer.parseInt(s.nextLine());
				System.out.println("Desideri applicare uno sconto? S/N" );
				choice=s.nextLine();
				if (choice.equals("S")) {
				
					System.out.println("Inserisci lo sconto in percentuale");
					sconto=Integer.parseInt(s.nextLine());
				}
				else 
					sconto=0;
				try {
				f=catering.emettiFattura(cf, sconto,id);
				System.out.println(f.toString());
				}catch(CateringException e) {
				System.out.println(e.getName());
				}
			
				
				
				break;		
				
				
			case 7:
				exit = true;
				break;
			default:
				System.out.println("Comando Sconosciuto");
				break;
			
			
			
			
			
			}
			
			
		
		
		}
		
		s.close();
		
				
		
		
		
	}
	
}