
public  class PreventivoFactory implements PreventivoAbstractFactory{
	
	
	@Override
	public PreventivoAbstract creaPreventivo() {
		return new Preventivo();
	}
	
	
	

}
