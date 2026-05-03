package trabajo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Representa las reservas de un hotel
 */
public class Reserva implements Comparable<Reserva>{
	private int codigo;
	private String nombreCliente;
	private int numHabitacion;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	
	//El formato que deben seguir las fechas introducidas
	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reserva(int codigo, String nombreCliente, int numHabitacion, String fechaEntrada, String fechaSalida) throws NegativeNumberException, ImpossibleDateException{
		setCodigo(codigo);
		setNombreCliente(nombreCliente);
		setNumHabitacion(numHabitacion);
		setFechaEntrada(fechaEntrada);
		setFechaSalida(fechaSalida);
	}
	
	public Reserva() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	/**
	 * Establece el valor del código siempre que este no sea negativo
	 * @param codigo 
	 * @throws NegativeNumberException Se lanza si el valor del código pasado como parámetro es negativo
	 */
	public void setCodigo(int codigo) throws NegativeNumberException {
		if (codigo <= 0) {
			throw new NegativeNumberException("El codigo debe ser un numero negativo");
		}
		
		this.codigo = codigo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * Establece el nombre del cliente si este no tiene un valor nulo ni es una cadena vacía
	 * @param nombreCliente 
	 */
	public void setNombreCliente(String nombreCliente) {
		if (nombreCliente == null || nombreCliente.isBlank()) {
			throw new IllegalArgumentException("Debe introducir el nombre del cliente que ha reservado");
		}
		
		this.nombreCliente = nombreCliente;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	/**
	 * Establece el valor del número de la habitación del cliente siempre que este no sea negativo
	 * @param numHabitacion
	 * @throws NegativeNumberException Se lanza si el valor del número de la habitación pasado como parámetro es negativo
	 */
	public void setNumHabitacion(int numHabitacion) throws NegativeNumberException {
		if (numHabitacion <= 0) {
			throw new NegativeNumberException("El número de habitación debe ser positivo");
		}
		
		this.numHabitacion = numHabitacion;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * Transforma la fecha introducida por el usuario en forma de String al formato LocalDate (con la forma dd/mm/aaaa)
	 * @param fechaEntrada
	 * @throws DateTimeParseException Se lanza si la fecha no cumple con el formato dd/mm/aaaa
	 * @throws ImpossibleDateException Se lanza si la fecha de entrada es posterior a la de salida
	 */
	public void setFechaEntrada(String fechaEntrada) throws DateTimeParseException, ImpossibleDateException {
		LocalDate nuevaFechaEntrada = LocalDate.parse(fechaEntrada, FORMATO);
		
		if (this.fechaSalida != null && !nuevaFechaEntrada.isBefore(this.fechaSalida)) {
			throw new ImpossibleDateException("La fecha de entrada debe ser anterior a la fecha de salida");
		}
		
		this.fechaEntrada = nuevaFechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * Transforma la fecha introducida por el usuario en forma de String al formato LocalDate (con la forma dd/mm/aaaa)
	 * @param fechaSalida
	 * @throws DateTimeParseException Se lanza si la fecha no cumple con el formato dd/mm/aaaa
	 * @throws ImpossibleDateException Se lanza si la fecha de salida es anterior a la de salida
	 */
	public void setFechaSalida(String fechaSalida) throws DateTimeParseException, ImpossibleDateException {
		LocalDate nuevaFechaSalida = LocalDate.parse(fechaSalida, FORMATO);
		
		if (this.fechaEntrada != null && !nuevaFechaSalida.isAfter(this.fechaEntrada)) {
			throw new ImpossibleDateException("La fecha de salida debe ser posterior a la fecha de entrada");
		}
		
		this.fechaSalida = nuevaFechaSalida;
	}
	
	public String toString() {
		return codigo + " - " + nombreCliente + " - " + numHabitacion + " - " + fechaEntrada.format(FORMATO) + " - " + fechaSalida.format(FORMATO);  
	}
	
	/**
	 * Comprueba si dos reservas son iguales por tener el mismo código
	 * @param otraReserva
	 * @return True si cumplen dicha condición
	 */
	public boolean equals(Reserva otraReserva) {
		boolean mismoCodigo = false;
		
		if (this.codigo == otraReserva.codigo) {
			mismoCodigo = true;
		}
		
		return mismoCodigo;
	}
	
	/**
	 * Ordena las fechas primero en función del numero de habitacion y, si este coincide, en función de la fecha de entrada
	 */
	public int compareTo(Reserva otraReserva) {
		int resultado;
		
		//Primero se considerara si tienen el mismo numHabitacion y, si es asi, entonces se comprobara si tambien tienen la misma fechaEntrada
		if (this.numHabitacion < otraReserva.numHabitacion) {
			resultado = -1;
		} else if (this.numHabitacion > otraReserva.numHabitacion) {
			resultado = 1;
		} else {
			resultado = this.fechaEntrada.compareTo(otraReserva.fechaEntrada);
		}
		
		return resultado;
	}
}
