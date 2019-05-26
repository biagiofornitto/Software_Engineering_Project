import java.util.*;

public class Ristorante {
	private String nome;
	private String PIVA;
	private List<Menu> listaMenu;
	
	public Ristorante(String PIVA, String nome) {
		this.PIVA = PIVA;
		this.nome = nome;
		this.listaMenu=new ArrayList<Menu>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPIVA() {
		return PIVA;
	}
	public List<Menu> getListaMenu() {
		return listaMenu;
	}


	public void setPIVA(String PIVA) {
		this.PIVA = PIVA;
	}

	@Override
	public String toString() {
		return "Ristorante [nome=" + nome + ", PIVA=" + PIVA + "]";
	}


	
	
	
	
	
}