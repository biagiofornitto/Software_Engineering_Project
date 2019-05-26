import java.util.ArrayList;
import java.util.List;

public class Menu {
	private int ID;
	private String nome;
	private List<Portata> portata;
	
	public Menu(int iD, String nome) {
		this.ID=ID;
		this.nome = nome;
		this.portata=new ArrayList<Portata>();
	}
	public Menu() {
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

	public List<Portata> getPortata() {
		return portata;
	}


	
	
	
	
}
