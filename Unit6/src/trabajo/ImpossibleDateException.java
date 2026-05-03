package trabajo;

public class ImpossibleDateException extends Exception {

	private static final long serialVersionUID = 1L;
	
	ImpossibleDateException(String mensaje){
		super(mensaje);
	}

}
