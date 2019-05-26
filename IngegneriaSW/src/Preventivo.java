
public class Preventivo extends PreventivoAbstract{
	
	
	
	
	public Preventivo() {
		
		
	}	
	
	
	@Override	
	public void calcolaTotale() {
		double prezzo=getPrezzoMenu()+getPrezzoModoServizio()+getPrezzoServizioTavola();
		setPrezzoTotale(prezzo);
	}



	public String toString() {
		return "Preventivo [prezzoTotale=€" + getPrezzoTotale() + ", prezzoMenu=€" + getPrezzoMenu() + ", prezzoModoServizio=€" + getPrezzoModoServizio() + ", prezzoServizioTavola=€"
				+ getPrezzoServizioTavola()+ "]";
	}
	
	

}
