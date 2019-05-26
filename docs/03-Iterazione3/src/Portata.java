
public class Portata {
	private int ID;
	private String nome;
	private double prezzo;
	public Portata(int ID, String nome, double prezzo) {
		
		this.ID = ID;
		this.nome = nome;
		this.prezzo = prezzo;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	@Override
	public String toString() {
		return "Portata [ID=" + ID + ", nome=" + nome + ", prezzo=" + prezzo + "]";
	}
	
	
	

}
