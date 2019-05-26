import java.util.*;

public class ServiziBase {
	private List<ServizioTavola> listTavola;
	private List<ModoServizio> listModoServizio;
	public ServiziBase() {
		
		this.listTavola = new ArrayList<ServizioTavola>();
		this.listModoServizio = new ArrayList<ModoServizio>();
	}
	public List<ServizioTavola> getListTavola() {
		return listTavola;
	}
	public List<ModoServizio> getListModoServizio() {
		return listModoServizio;
	}
	
	public ServizioTavola getServizioT(String nome) {
		Iterator<ServizioTavola> iterator = listTavola.iterator();
		while (iterator.hasNext()) {
			ServizioTavola st = iterator.next();
			if (st.getNome()==nome)
				return st;
		}
		return null;
	}
	
	public ModoServizio getModoServizio(int ID) {
		Iterator<ModoServizio> iterator = listModoServizio.iterator();
		while (iterator.hasNext()) {
			ModoServizio m = iterator.next();
			if (m.getID()==ID)
				return m;
		}
		return null;
	}
	
	
	public void nuovoServizioT(String nome, double prezzo) {
		ServizioTavola st=new ServizioTavola(nome, prezzo);
		getListTavola().add(st);
		
	}
	
	public void nuovoModoS(int ID, String nome, double prezzo) {
		ModoServizio ms=new ModoServizio(ID, nome, prezzo);
		getListModoServizio().add(ms);
	};
	
	
	
	
	
	
	
	
	
	
}
