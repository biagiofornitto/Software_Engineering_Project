import java.util.Date;

public class Prenotazione {

	private static int ID = 0;
	private String luogo;
	private Date data;
	private int invitati;
	private Cliente cliente;
	private Preventivo preventivo;
	private Menu menu;
	private Animazione an;
	private Navetta nav;
	private ServizioTavola st;
	private ModoServizio ms;
	
	
	
	public Prenotazione(String luogo, Date data, int invitati) {
		ID = ID +1 ;
		this.luogo = luogo;
		this.data = data;
		this.invitati = invitati;
		/*this.cliente = new Cliente();*/  /*abbiamo il metodo associa cliente, non creiamo clienti in corso di prenotazione*/
		/*this.preventivo = new Preventivo();*/ /*abbiamo la creazione del nuovo preventivo nel calcola preventivo*/
	}
	
	
	public Prenotazione() {
		
		
	};

	public int getID() {
		return ID;
	}

	

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getInvitati() {
		return invitati;
	}

	public void setInvitati(int invitati) {
		this.invitati = invitati;
	}

	
	
	
	
	


	@Override
	public String toString() {
		return "Prenotazione [ID=" + ID + ", luogo=" + luogo + ", data=" + data + ", invitati=" + invitati + "]";
	}
	
	
	
	public void setAn(Animazione an) {
		this.an = an;
	}

	public void setNav(Navetta nav) {
		this.nav = nav;
	}

	public void setSt(ServizioTavola st) {
		this.st = st;
	}

	public void setMs(ModoServizio ms) {
		this.ms = ms;
	}

	public void setServiziBase(ServizioTavola st,ModoServizio ms) {
		setSt(st);
		setMs(ms);
		
	}
	public void setServiziAggiuntivi(Animazione an,Navetta nav) {
		setAn(an);
		setNav(nav);
		
		
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void CalcolaPrev() {
		double m=0;
		double an=0;
		double st=0;
		double ms=0;
		double nav=0;
		
		m=this.menu.getPrezzoMenu()*invitati;
		
		/*servizi base*/
		
		st=this.st.getPrezzo()*invitati;
		ms=this.ms.getPrezzo();
		
		/*servizi aggiuntivi*/
		
		if (this.an!=null) {
			
			an=this.an.getPrezzo();
		}
		
		if (this.nav!=null) {
			
			nav=this.nav.getPrezzo();
		}
		
		this.preventivo=new Preventivo(m,nav,ms,st,an);
		
		
		
	}
	
	
	
	
	
	
	
	
}
