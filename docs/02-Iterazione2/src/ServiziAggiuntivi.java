import java.util.*;

public class ServiziAggiuntivi {
	private List<Navetta> listNavetta;
	private List<Animazione> listAnimazione;
	public ServiziAggiuntivi() {
		this.listNavetta = new ArrayList<Navetta>();
		this.listAnimazione = new ArrayList<Animazione>();
	}
	public List<Navetta> getListNavetta() {
		return listNavetta;
	}

	public List<Animazione> getListAnimazione() {
		return listAnimazione;
	}
	
	public Animazione getAnimazione(String nome) {
		Iterator<Animazione> iterator = listAnimazione.iterator();
		while (iterator.hasNext()) {
			Animazione an = iterator.next();
			if (an.getNome()==nome)
				return an;
		}
		return null;
	}
	
	
	public Navetta getNavetta(int postiNavetta) {
		Iterator<Navetta> iterator = listNavetta.iterator();
		while (iterator.hasNext()) {
			Navetta nav = iterator.next();
			if (nav.getPosti_navetta_ID()==postiNavetta)
				return nav;
		}
		return null;
	}
	
	
	public void nuovaNavetta(String nome, int posti_navetta_ID, double prezzo) {
		Navetta nav=new Navetta(nome, posti_navetta_ID, prezzo);
		getListNavetta().add(nav);
	}
	
	public void nuovaAn(String nome, double prezzo) {
		Animazione an=new Animazione(nome, prezzo);
		getListAnimazione().add(an);
	}
	
	
	
}
