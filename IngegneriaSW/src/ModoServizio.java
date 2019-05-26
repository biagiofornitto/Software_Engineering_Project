
public class ModoServizio {
	private int ID;
	private String nome;
	private double prezzo;
	
	public ModoServizio(int ID, String nome, double prezzo) {
		this.ID = ID;   /*identifica bouffet o servizio di sala*/
		this.nome = nome;
		this.prezzo = prezzo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	@Override
	public String toString() {
		return "ModoServizio [ID=" + ID + ", nome=" + nome + ", prezzo=" + prezzo + "]";
	}
	
	
}
