package trabajo;

public class NegativeNumberException extends Exception {

	private static final long serialVersionUID = 1L;

	NegativeNumberException(String mensaje){
		super(mensaje);
	}
}
