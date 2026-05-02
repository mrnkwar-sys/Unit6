package trabajo;

public class ImpossibleDepartureDateException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "La fecha de salida debe ser POSTERIOR a la fecha de entrada";
	}

}
