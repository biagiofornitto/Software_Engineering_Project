public class Navetta {
	private String nome;
	private int posti_navetta_ID;
	private double prezzo;
	public Navetta(String nome, int posti_navetta_ID, double prezzo) {
		this.nome = nome;
		this.posti_navetta_ID = posti_navetta_ID;
		this.prezzo = prezzo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPosti_navetta_ID() {
		return posti_navetta_ID;
	}
	public void setPosti_navetta_ID(int posti_navetta_ID) {
		this.posti_navetta_ID = posti_navetta_ID;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		return "Navetta [nome=" + nome + ", posti_navetta_ID=" + posti_navetta_ID + ", prezzo=" + prezzo + "]";
	}
	
	
	
}
