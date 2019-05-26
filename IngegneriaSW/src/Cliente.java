import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private List<Fattura> listaFatture;
	private Fattura f;
	
	public Cliente(String nome, String cognome, String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.listaFatture=new ArrayList<Fattura>();

	}
	public Cliente() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	

	public List<Fattura> getListaFatture() {
		return listaFatture;
	}
	
	
	public void nuovaFattura(double totale,int sconto,int id) {
		
		f=new Fattura(totale,sconto,id);
		
		
	}
	
	
	
	
	
	public Fattura getF() {
		
		return f;
	}

	public void associaFattura() {
		
		listaFatture.add(getF());
		
		
	}
	
	
	

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + "]";
	}
	
	
}
