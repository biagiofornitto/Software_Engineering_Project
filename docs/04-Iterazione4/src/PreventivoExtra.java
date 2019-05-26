
public class PreventivoExtra extends PreventivoAbstract{

	
	public PreventivoExtra() {
		
	}	
	
	
	

	@Override
	public void calcolaTotale() {
		double prezzo=getPrezzoMenu()+getPrezzoModoServizio()+getPrezzoServizioTavola()+getPrezzoNavetta()+getPrezzoAnimazione();
		setPrezzoTotale(prezzo);
	}


	public String toString() {
		return "Preventivo [prezzoTotale=€" + getPrezzoTotale() + ", prezzoMenu=€" + getPrezzoMenu() + ", prezzoModoServizio=€" + getPrezzoModoServizio() + ", prezzoServizioTavola=€"
				+ getPrezzoServizioTavola()+", prezzoNavetta=€"+getPrezzoNavetta() +  ", prezzoAnimazione=€"+getPrezzoAnimazione()+"]";
	}
	
	
	
	
	
	
}
