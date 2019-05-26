
public class Portata {
	private int ID;
	private String nome;
	private float prezzo;
	public Portata(int iD, String nome, float prezzo) {
		
		this.ID = this.ID;
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
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		return "Portata [ID=" + ID + ", nome=" + nome + ", prezzo=" + prezzo + "]";
	}
	
	
	

}
