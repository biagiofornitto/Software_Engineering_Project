
public class PreventivoExtraFactory implements PreventivoAbstractFactory{
	
	@Override
	public PreventivoAbstract creaPreventivo() {
		return new PreventivoExtra();
	}
	
	
}
