
public class Preventivo {
	
	private  static int ID = 0;
	private float prezzoTotale;
	
	
	
	
	
	public Preventivo(float prezzoTotale) {
		ID=ID + 1 ;
		this.prezzoTotale = prezzoTotale;
		
	}
	public Preventivo(){
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public float getPrezzoTotale() {
		return prezzoTotale;
	}
	public void setPrezzoTotale(float prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}
	
	

}
