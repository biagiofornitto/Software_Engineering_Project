import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import exceptions.CateringException;

public class TestCatering {
	
	@Test
	public void testInserisciERicercaCliente() throws CateringException {
		
		Catering catering = Catering.getInstance();
		Scanner s = new Scanner(System.in);
		
		String nome;
		String cognome;
		String cf;
		
		System.out.println("Inserisci il tuo primo cliente!");
		System.out.println("Nome: ");
		nome = s.nextLine();
		System.out.println("Cognome: ");
		cognome = s.nextLine();
		System.out.println("CF: ");
		cf = s.nextLine();
		
		catering.nuovoCliente(nome, cognome, cf);
		Cliente cTest = new Cliente(nome, cognome, cf);
		
		// test corretto inserimento del cliente		
		assertEquals(cTest.toString(), catering.ricercaCliente(cf).toString());
		
		// test presenza di numeri nel nome o nel cognome
		for (char c : catering.ricercaCliente(cf).getNome().toCharArray())
			assertFalse(Character.isDigit(c));
		for (char c : catering.ricercaCliente(cf).getCognome().toCharArray())
			assertFalse(Character.isDigit(c));
		
	}
	
	
	@Test
	public void testInserisciERicercaRistorante() throws CateringException {
		
		Catering catering = Catering.getInstance();
		Scanner s = new Scanner(System.in);
		
		String piva;
		String nome;
		
		System.out.println("Inserisci il tuo primo ristorante!");
		System.out.println("Piva: ");
		piva= s.nextLine();
		System.out.println("Nome: ");
		nome = s.nextLine();
	
		catering.nuovoRistorante(piva, nome);
		Ristorante rTest = new Ristorante(piva,nome);
		
		// test corretto inserimento del ristorante		
		assertEquals(rTest.toString(), catering.ricercaRistorante(piva).toString());
		
		// test presenza di numeri nel nome
		for (char c : catering.ricercaRistorante(piva).getNome().toCharArray())
			assertFalse(Character.isDigit(c));
		
	}
	
	
	
	@Test
	public void testInserisciPrERicercaCateringsClienteERistorante() throws CateringException {
		Catering catering= Catering.getInstance(); /*singleton*/
		
		catering.nuovoCliente("Giovanni", "Storti", "X002");
		catering.nuovoRistorante("X001","Etrusca");
		catering.nuovoMenu("X001",1,"MenuDellaCasa");
		catering.nuovaPortata("X001",1,1,"pasta",3.50);
		
		
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
		
		
		
		
	
		Scanner s = new Scanner(System.in);
		String choice;
		String cf="X002";
		String piva="X001";
		int idmenu=1;
		Date data=null;
		String luogo;
		int invitati;
		int ms;
		int nav;
		List<Menu> lm;
		String an;
		String st;
		List<Prenotazione> pr;
		Prenotazione p;
		
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		
		
		catering.nuovaPrenotazione();
		assertNotNull(catering.getP());
		
				
		catering.inserisciMenuRistorante(piva,idmenu);
				
		System.out.println("Test inserimento prenotazione");
		
		System.out.println("Inserisci data,luogo e invitati del catering." );
		
			
			
			System.out.println("Data: gg-mm-yyyy");
			try {
			data=sdf.parse(s.nextLine());
			} catch (ParseException e) {
				   System.out.println("Data malformata o inesistente \n");
					 
				}
			
			
		
		
		
		System.out.println("Luogo: ");
		luogo=s.nextLine();
		System.out.println("N° invitati: ");
		invitati=Integer.parseInt(s.nextLine());
		
		catering.inserisciLuogoCatering(luogo, data, invitati);
		assertEquals(luogo,catering.getP().getLuogo());
		assertEquals(invitati,catering.getP().getInvitati());
		assertEquals(data,catering.getP().getData());
		
		
	
				System.out.println("Scegli il servizio (0 per bouffet, 1 per servizio di sala)");
				ms=Integer.parseInt(s.nextLine());
				System.out.println("Scegli il servizio tavola (Base,Medio,Regale)");
				st=s.nextLine();
			
				catering.inserisciTipoServizio(st, ms);
				assertEquals(ms,catering.getP().getMs().getID());
				assertEquals(st,catering.getP().getSt().getNome());
			
				

		System.out.println("Desideri i servizi aggiuntivi (navetta e animazione) ? S/N");
		choice=s.nextLine();
		if (choice.equals("S")) {
			
			
					System.out.println("Posti navetta : (50,100)");
					nav=Integer.parseInt(s.nextLine());
					System.out.println("Pacchetto Animazione : (Silver,Gold,Platinum)");
					an=s.nextLine();
					
					catering.aggiungiPack(nav, an);
					
					assertEquals(an,catering.getP().getAn().getNome());
					assertEquals(nav,catering.getP().getNav().getPosti_navetta_ID());
					
			
			/*la factory si trova nella classe prenotazione*/
			catering.getP().setPrevfactory(new PreventivoExtraFactory());  /*set dell' abstractfactory per PreventivoExtra*/
				
					
		}
		else 
		{
			catering.getP().setPrevfactory(new PreventivoFactory());	/*set dell'abstractfactory per Preventivo*/
			assertEquals("N", choice);
		}
		assertNotNull(catering.getP().getPrevfactory());
		System.out.println("Desideri visualizzare il preventivo ? S/N");
		choice=s.nextLine();
		
		catering.getP().CalcolaPrev(); /*il preventivo viene istanziato e calcolato*/
		assertNotNull(catering.getP().getPreventivo());
		
		
		
		if (choice.equals("S"))
			System.out.println( catering.getP().getPreventivo().toString());
		
				catering.associaCliente(cf);
				assertEquals(cf,catering.getP().getCliente().getCodiceFiscale());
				System.out.println(catering.ricercaCliente(cf).toString());
			
		System.out.println("Vuoi confermare l'inserimento del catering ? S/N");
		choice=s.nextLine();
		if (choice.equals("S")) {
			
			catering.confermaCatering();
			System.out.println("Catering inserito con successo\n");	
		}
		else
		{
			assertEquals("N",choice);
			System.out.println("Inserimento catering annullato");
		
		}
		/*test per RicercaCateringsCliente*/	
			System.out.println("Test RicercaCateringsCliente");
			pr=catering.ricercaCateringsCliente(cf);
			System.out.println("Caterings del cliente: "+catering.ricercaCliente(cf).toString());
			Iterator<Prenotazione> iterator = pr.iterator();
			while (iterator.hasNext()) {
				p=iterator.next();
				assertEquals(cf,p.getCliente().getCodiceFiscale());
				System.out.println(p.toString()+"\n");
				
			}
			
		/*test per RicercaCateringsRistorante*/	
			System.out.println("Test RicercaCateringsRistorante");
			pr=catering.ricercaCateringsRistorante(piva);
			lm=catering.ricercaRistorante(piva).getListaMenu();
			System.out.println("Caterings del ristorante: "+catering.ricercaRistorante(piva).toString());
			iterator = pr.iterator();
			while (iterator.hasNext()) {
				p=iterator.next();
				/*verifico che il menu delle prenotazioni restituite dal metodo sia un menù del ristorante cercato*/
				
				assertTrue(lm.contains(p.getMenu()));
				
				System.out.println(p.toString()+"\n");
			
			}
			
	
	
	
	}
	

	
	
	
}
