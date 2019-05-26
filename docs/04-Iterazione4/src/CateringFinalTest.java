import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import exceptions.*;
import java.util.Date;


public class CateringFinalTest {
	
	//Si verifica che l'inserimento del cliente generi eccezione in caso di nome con numeri.
	@Test(expected=CateringException.class)
	public void InserisciClienteFinalTestNome() throws CateringException {
		Catering catering = Catering.getInstance();
		String nome = "B146io";
		String cognome = "Fornitto";
		String cf = "X001";
		catering.nuovoCliente(nome, cognome, cf);
	}
	
	//Si verifica che l'inserimento del cliente generi eccezione in caso di cognome con numeri.
	@Test(expected=CateringException.class)
	public void InserisciClienteFinalTestCognome() throws CateringException {
		Catering catering = Catering.getInstance();
		String nome = "Emanuele";
		String cognome = "B0n4ventura";
		String cf = "X002";
		catering.nuovoCliente(nome, cognome, cf);
	}
	
	//Si verifica che l'inserimento del cliente generi eccezione in caso di CF con spazi.
	@Test(expected=CateringException.class)
	public void InserisciClienteFinalTestCF() throws CateringException {
		Catering catering = Catering.getInstance();
		String nome = "Matteo";
		String cognome = "Bonaccorso";
		String cf = "X 001";
		catering.nuovoCliente(nome, cognome, cf);
	}
	
	//Si verifica che l'inserimento del cliente generi eccezione in caso di CF già presente nel sistema.
	@Test(expected=CateringException.class)
	public void InserisciClienteFinalTestSame () throws CateringException {
		Catering catering = Catering.getInstance();
		String nome = "Salvo";
		String cognome = "Ficarra";
		String cf = "X001";
		catering.nuovoCliente(nome, cognome, cf);
		
		nome = "Valentino";
		cognome = "Picone";
		cf = "X001";
		catering.nuovoCliente(nome, cognome, cf);
	}
	
	//Si verifica che l'inserimento del cliente generi eccezione in caso di nome nullo.
	@Test(expected=CateringException.class)
	public void InserisciCateringFinalTestEmptyName () throws CateringException {
		Catering catering = Catering.getInstance();
		String nome = "";
		String cognome = "Baglioni";
		String cf = "X001";
		catering.nuovoCliente(nome, cognome, cf);
	}
	
	//Si verifica che l'inserimento del cliente generi eccezione in caso di cognome nullo.
	@Test(expected=CateringException.class)
	public void InserisciCateringFinalTestEmptySurname () throws CateringException {
		Catering catering = Catering.getInstance();
		String nome = "Giovanni";
		String cognome = "";
		String cf = "X001";
		catering.nuovoCliente(nome, cognome, cf);
	}
	
	//Si verifica che l'inserimento del cliente eccezione in caso di CF nullo.
	@Test(expected=CateringException.class)
	public void InserisciClienteFinalTestEmptyCF () throws CateringException {
		Catering catering = Catering.getInstance();
		String nome = "Giacomino";
		String cognome = "Poretti";
		String cf = "";
		catering.nuovoCliente(nome, cognome, cf);
	}
	
	//Si verifica che la ricerca del cliente generi eccezione in caso di CF non valido
	@Test(expected=CateringException.class)
	public void RicercaClienteFinalTest() throws CateringException {
		Catering catering =Catering.getInstance();
		String cf = "B ens on5";
		
		catering.ricercaCliente(cf);
	} 
	
	
	
	//Si verifica che l'inserimento del ristorante generi eccezione in caso do PIVA con spazi.
		@Test(expected=CateringException.class)
		public void InserisciRistoranteFinalTestPIVA() throws CateringException {
			Catering catering = Catering.getInstance();
			String nome = "Etrusca";
			String PIVA = "X 001";
			catering.nuovoRistorante(PIVA, nome);
		}
		
		
		//Si verifica che l'inserimento del ristorante generi eccezione in caso di PIVA nulla.
		@Test(expected=CateringException.class)
		public void InserisciRistoranteFinalTestEmptyPIVA () throws CateringException {
			Catering catering = Catering.getInstance();
			String nome = "Etrusca";
			String PIVA = "";
			catering.nuovoRistorante(PIVA, nome);
		}
	
	
		//Si verifica che l'inserimento di una prenotazione generi eccezione in caso di data passata
		 @Test(expected=CateringException.class)
		 public void InserisciLuogoCateringFinalTest() throws CateringException {
			 Catering catering = Catering.getInstance();
			
			 catering.nuovaPrenotazione();
			 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			 sdf.setLenient(false);
			 int invitati=3;
			 try {
			 Date data=sdf.parse("01-12-2015");
			 catering.inserisciLuogoCatering("Bronte",data, invitati);
			 	
			 } catch (ParseException e) {
				   System.out.println("Data malformata o inesistente \n");
				 
			}
	
		 }
		 
		//Si verifica che l'emissione di una fattura generi un'eccezione in caso di sconto negativo
			@Test(expected=CateringException.class)
			public void EmettiFatturaFinalTest () throws CateringException {
				Catering catering=Catering.getInstance();
				
				String cf="X001";
				catering.nuovoCliente("Giuseppe", "Grana", cf);
				catering.nuovaPrenotazione();
				int id=catering.getP().getID();
				int sconto=-50;
				catering.emettiFattura(cf, sconto, id);
				
				
			}
		 
		 
	
	
	
	
}
