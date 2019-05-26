package exceptions;
import java.lang.Exception;

public class CateringException extends Exception{

	
		private String exceptionName;
		
		public CateringException (String s) {
			exceptionName=s;
		}
		
		public String getName() {
			return exceptionName;
		}
		
		public void setName(String s) {
			exceptionName=s;
		}
	
	
	
}
