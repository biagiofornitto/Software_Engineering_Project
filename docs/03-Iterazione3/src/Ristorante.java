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

	/*funzione di ricerca menu perchè ristorante ha la lista dei menu*/
	public Menu ricercaMenu(int ID) {
		Iterator<Menu> iterator = listaMenu.iterator();
		while (iterator.hasNext()) {
			Menu m = iterator.next();
			if (m.getID()==ID)
				return m;
		}
		return null;
	}
	
	public Menu ricercaMenu(String nome) {
		Iterator<Menu> iterator = listaMenu.iterator();
		while (iterator.hasNext()) {
			Menu m = iterator.next();
			if (m.getNome().equals(nome))
				return m;
		}
		return null;
	}
	
	
	/*crud menu*/
	/*manca l'aggiorna menu perchè il problema è che dovrei fare due funzioni separate in quanto menu ha i campi di tipo diverso
	 * non è come cliente e ristorante che hanno tutti i campi di tipo string, quindi al limite non giela facciamo 
	 * stessa situazione per la portata
	 * in realtà si possono fare basta un cast quando serve l'int, la questione è se si deve mettere nell'interfaccia finale o meno*/
	
	public void nuovoMenu(int ID, String nome) {
		Menu menu=new Menu(ID,nome);
		getListaMenu().add(menu);			/*riferito all'istanza di ristorante corrente*/
	}
	
	
	public void eliminaMenu(int ID) {
	    Menu menu= ricercaMenu(ID);
		if(confermaEliminaMenu())
			getListaMenu().remove(menu);
		
	}
	public boolean confermaEliminaMenu() {
		System.out.println("Sei sicuro di voler eliminare il riferimento al menu?\nLa scelta è irreversibile. (y/n)");
		Scanner input = new Scanner(System.in);
		return (input.nextLine()=="y");
		
	}
	
	
	
	
	
	
}