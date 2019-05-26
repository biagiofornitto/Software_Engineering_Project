import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private int ID;
	private String nome;
	private List<Portata> listPortata;
	
	public Menu(int ID, String nome) {
		this.ID=ID;
		this.nome = nome;
		this.listPortata=new ArrayList<Portata>();
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

	public List<Portata> getListPortata() {
		return listPortata;
	}

	public double getPrezzoMenu() {
		double prezzoMenu=0;
		Iterator<Portata> iterator = listPortata.iterator();
		while (iterator.hasNext()) {
			Portata p = iterator.next();
			prezzoMenu=prezzoMenu+p.getPrezzo();
			
		}
		return prezzoMenu;
		
		
			
	}
	
	/* due metodi di ricerca per la portata*/
	public Portata ricercaPortata(int ID) {
		Iterator<Portata> iterator = listPortata.iterator();
		while (iterator.hasNext()) {
			Portata p= iterator.next();
			if (p.getID()==ID)
				return p;
		}
		return null;
	}
	
	public Portata ricercaPortata(String portata) {
		Iterator<Portata> iterator = listPortata.iterator();
		while (iterator.hasNext()) {
			Portata p = iterator.next();
			if (p.getNome().equals(nome))
				return p;
		}
		return null;
	}
	
	/*crud portata*/
	
	public void nuovaPortata(int ID, String nome, double prezzo) {
		Portata p=new Portata(ID,nome,prezzo);
		getListPortata().add(p);				/*riferito all'istanza di menu corrente*/
	}
	public void eliminaPortata(int ID) {
		Portata p = ricercaPortata(ID);
		if(confermaEliminaPortata())
		getListPortata().remove(p);
		
	}
	public boolean confermaEliminaPortata() {
		System.out.println("Sei sicuro di voler eliminare il riferimento alla portata?\nLa scelta è irreversibile. (y/n)");
		Scanner input = new Scanner(System.in);
		return (input.nextLine()=="y");
		
	
	}
	
	
}
