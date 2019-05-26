
public class Fattura {
	double totale;
	int sconto;
	double prezzo;
	int id;
	
	
	
	
	
	
	public Fattura(double prezzo, int  sconto,int id) {
		this.id=id;
		this.prezzo= prezzo;
		this.sconto=sconto;
	}



	
	
	
	public void calcolaTotale() {
			this.totale=this.prezzo-this.prezzo*sconto/100;	/*applicazione dello sconto*/

		
	}






	@Override
	public String toString() {
		return "Fattura [totale=" + totale + ", sconto=" + sconto + "%, prezzo=" + prezzo + ", id=" + id + "]";
	}







	
	
	
	
	
	
}
