
public abstract class PreventivoAbstract {

	
	
	private double prezzoTotale;
	private double prezzoMenu;
	private double prezzoServizioTavola;
	private double prezzoModoServizio;
	private double prezzoNavetta;
	private double prezzoAnimazione;

		

	public abstract void calcolaTotale();
	

	

	public double getPrezzoTotale() {
		return prezzoTotale;
	}
	
	

	public void setPrezzoTotale(double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}
	public double getPrezzoMenu() {
		return prezzoMenu;
	}
	public void setPrezzoMenu(double prezzoMenu) {
		this.prezzoMenu = prezzoMenu;
	}

	public double getPrezzoModoServizio() {
		return prezzoModoServizio;
	}
	public void setPrezzoModoServizio(double prezzoModoServizio) {
		this.prezzoModoServizio = prezzoModoServizio;
	}
	public double getPrezzoServizioTavola() {
		return prezzoServizioTavola;
	}
	public void setPrezzoServizioTavola(double prezzoServizioTavola) {
		this.prezzoServizioTavola = prezzoServizioTavola;
	}
	
	
	
	public double getPrezzoNavetta() {
		return prezzoNavetta;
	}
	public void setPrezzoNavetta(double prezzoNavetta) {
		this.prezzoNavetta = prezzoNavetta;
	}
	public double getPrezzoAnimazione() {
		return prezzoAnimazione;
	}
	public void setPrezzoAnimazione(double prezzoAnimazione) {
		this.prezzoAnimazione = prezzoAnimazione;
	}

	
	
	
	
	
	
}
