import java.util.Date;

public class Prenotazione {

	private static int ID = 0;
	private String luogo;
	private Date data;
	private int invitati;
	private Cliente cliente;
	private Preventivo preventivo;
	private Menu menu;
	
	
	public Prenotazione(String luogo, Date data, int invitati) {
		ID = ID +1 ;
		this.luogo = luogo;
		this.data = data;
		this.invitati = invitati;
		this.cliente = new Cliente();
		this.preventivo = new Preventivo();
		this.menu = new Menu();
	}

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
	
	
	
	
	
}
