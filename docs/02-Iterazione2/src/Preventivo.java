
public class Preventivo {
	
	private  static int ID = 0;
	private double prezzoTotale;
	
	private double prezzoMenu;
	private double prezzoNavetta;
	private double prezzoModoServizio;
	private double prezzoServizioTavola;
	private double prezzoAnimazione;
	
	
	public Preventivo(double prezzoMenu,double prezzoNavetta,double prezzoModoServizio, double prezzoServizioTavola,double prezzoAnimazione) {
		ID=ID + 1 ;
		setPrezzoMenu(prezzoMenu);
		setPrezzoNavetta(prezzoNavetta);
		setPrezzoModoServizio(prezzoModoServizio);
		setPrezzoServizioTavola(prezzoServizioTavola);
		setPrezzoAnimazione(prezzoAnimazione);
		setPrezzoTotale(prezzoMenu,prezzoNavetta,prezzoModoServizio,prezzoServizioTavola,prezzoAnimazione);
		
	}
	/*costruttore vuoto*/
	public Preventivo(){
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public double getPrezzoTotale() {
		return prezzoTotale;
	}
	public void setPrezzoTotale(double prezzoMenu,double prezzoNavetta,double prezzoModoServizio,double prezzoServizioTavola, double prezzoAnimazione) {
		this.prezzoTotale = prezzoMenu+prezzoNavetta+prezzoModoServizio+prezzoServizioTavola+prezzoAnimazione;
	}
	public double getPrezzoMenu() {
		return prezzoMenu;
	}
	public void setPrezzoMenu(double prezzoMenu) {
		this.prezzoMenu = prezzoMenu;
	}
	public double getPrezzoNavetta() {
		return prezzoNavetta;
	}
	public void setPrezzoNavetta(double prezzoNavetta) {
		this.prezzoNavetta = prezzoNavetta;
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
	public double getPrezzoAnimazione() {
		return prezzoAnimazione;
	}
	public void setPrezzoAnimazione(double prezzoAnimazione) {
		this.prezzoAnimazione = prezzoAnimazione;
	}
	
	

}
