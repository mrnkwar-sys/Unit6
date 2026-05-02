package trabajo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Reserva {
	private int codigo;
	private String nombreCliente;
	private int numHabitacion;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reserva(int codigo, String nombreCliente, int numHabitacion, String fechaEntrada, String fechaSalida) throws ImpossibleDepartureDateException{
		this.codigo = codigo;
		this.nombreCliente = nombreCliente;
		this.numHabitacion = numHabitacion;
		setFechaEntrada(fechaEntrada);
		setFechaSalida(fechaSalida);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) throws DateTimeParseException {
		this.fechaEntrada = LocalDate.parse(fechaEntrada, FORMATO);
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) throws DateTimeParseException, ImpossibleDepartureDateException {
		this.fechaSalida = LocalDate.parse(fechaSalida, FORMATO);
		
		if (this.fechaSalida != null && !this.fechaSalida.isAfter(this.fechaEntrada)) {
			throw new ImpossibleDepartureDateException();
		}
	}
	
	public String toString() {
		return nombreCliente + " - " + codigo + " - " + fechaEntrada + " - " + fechaSalida;  
	}
	
	public boolean equals(Reserva otraReserva) {
		boolean mismoCodigo = false;
		
		if (this.codigo == otraReserva.codigo) {
			mismoCodigo = true;
		}
		
		return mismoCodigo;
	}
	
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
