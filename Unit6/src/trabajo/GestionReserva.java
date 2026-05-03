package trabajo;

import java.io.*;
import java.time.format.DateTimeParseException;
import java.util.TreeSet;

public class GestionReserva {
	private TreeSet <Reserva> listaReservas;
	
	GestionReserva(){
		listaReservas = new TreeSet<>();
	}
	
	GestionReserva(TreeSet <Reserva> listaReservas){
		this.listaReservas = listaReservas;
	}
	
	/**
	 * Añade una reserva a la colección si esta no existía ya en ella
	 * @param reserva
	 */
	public void anadirReserva(Reserva reserva) {
		if (listaReservas.add(reserva)) {
			System.out.println("Se ha añadido la reserva correctamente");
		} else {
			System.out.println("No se ha podido añadir la reserva porque ya había una reserva igual registrada");
		}
	}
	
	/**
	 * Busca una reserva con el mismo código que ha sido introducido por el usuario
	 * @param codigo
	 * @return True si se encuentra una reserva con ese código en la colección
	 */
	public boolean buscarReserva(int codigo) {
		boolean reservaEncontrada = false;
		
		for (Reserva re : listaReservas) {
			if (re.getCodigo() == codigo) {
				System.out.println(re.toString());
				reservaEncontrada = true;
			}
		}
		
		return reservaEncontrada;
	}
	
	/**
	 * Muestra la colección con todas las reservas, en caso de que tenga al menos una
	 */
	public void listarReservas() {
		if (!listaReservas.isEmpty()) {
			for (Reserva re : listaReservas) {
				System.out.println(re.toString());
			}
		} else {
			System.out.println("No hay ninguna reserva registrada");
		}
	}
	
	/**
	 * Modifica las fechas de entrada y salida de la reserva cuyo código coincida con el introducido por el usuario
	 * @param codigo
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @return True si encuentra la reserva y se han podido modificar las fechas
	 * @throws ImpossibleDateException Se lanza se la fecha de salida no es posterior a la de entrada, o lo contrario
	 */
	public boolean modificarReserva(int codigo, String fechaEntrada, String fechaSalida) throws ImpossibleDateException {
		boolean fechasModificadas = false;
		
		for (Reserva re : listaReservas) {
			if (re.getCodigo() == codigo) {
				try {
					re.setFechaEntrada(fechaEntrada);
					re.setFechaSalida(fechaSalida);
					fechasModificadas = true;
				} catch (DateTimeParseException e) {
				    System.out.println("Error: El formato de fecha no es válido. Use dd/mm/aaaa.");
				} catch (ImpossibleDateException e) {
				    System.out.println("Error lógico: " + e.getMessage());
				}
			}
		}
		
		return fechasModificadas;
	}
	
	/**
	 * Elimina la reserva cuyo código coincida con el introducido por el usuario
	 * @param codigo
	 * @return True si se encuentra la reserva en la colección y, por tanto, es posible eliminarla
	 */
	public boolean eliminarReserva(int codigo) {
		return listaReservas.removeIf(reserva -> reserva.getCodigo() == codigo);
	}
	
	/**
	 * Guarda las reservas contenidas en la colección en un archivo
	 * No he puesto el true en el FileWriter considerando que puedo controlar que las reservas no se repitan en la colección, pero no en el archivo
	 * Además de que si se modificase una reserva posteriormente a que esta hubiera sido añadida al archivo, la reserva aparecería dos veces en el archivo
	 * @return True si, por tener la colección al menos uhna reserva, se han podido guardar en el archivo
	 */
	public boolean guardarReserva() {
		boolean reservasGuardadas = false;
		if (!listaReservas.isEmpty()) {
			try {
				BufferedWriter in = new BufferedWriter(new FileWriter("/home/deck/git/Unit6/Unit6/src/trabajo/ReservasRegistradas"));
				
				for (Reserva re : listaReservas) {
					in.write(re.toString());
					in.newLine();
				}
				
				reservasGuardadas = true;
				
				in.flush();
				in.close();
			} catch (IOException e) {
				e.toString();
			}
		} else {
			reservasGuardadas = false;
		}
		
		return reservasGuardadas;
	}
}
