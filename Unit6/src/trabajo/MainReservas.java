package trabajo;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainReservas {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ImpossibleDateException, NegativeNumberException {
		GestionReserva reserva = new GestionReserva();
		Reserva reser = new Reserva();
		
		//La opcion elegida por el usuario
		int opcion;
		
		//El codigo de la reserva
		int codigo = 1;
		
		//El numero de la habitacion reservada
		int numHabitacion;
		
		//El nombre del cliente que ha reservado
		String nombreCliente;
		
		//Las fechas de entrada y salida introducidas por el usuario
		String fechaEntrada;
		String fechaSalida;
		
		do {
			mostrarMenu();
			
			opcion = sc.nextInt();
			
			//Limpia el buffer
			sc.nextLine();
			
			switch(opcion) {
			case 1 ->{
				codigo = comprobarNumero("Introduzca el codigo de la reserva: ");
				reser.setCodigo(codigo);
				
				numHabitacion = comprobarNumero("Introduzca el numero de la habitacion reservada: ");
				reser.setNumHabitacion(numHabitacion);
				
				//Limpia el buffer
				sc.nextLine();
				
				nombreCliente = comprobarString("Introduzca el nombre del cliente: ");
				reser.setNombreCliente(nombreCliente);
				
				while (true) {
					System.out.println("Introduzca la fecha de entrada con el formato dd/mm/aaaa: ");
					fechaEntrada = sc.nextLine();
					
					try {
					    reser.setFechaEntrada(fechaEntrada);
					    System.out.println("Fecha de entrada establecida correctamente.");
					    
					    break;
					} catch (DateTimeParseException e) {
					    System.out.println("Error: El formato de fecha no es válido. Use dd/mm/aaaa.");
					} catch (ImpossibleDateException e) {
					    System.out.println("Error lógico: " + e.getMessage());
					}
				}
				
				while(true) {
					System.out.println("Introduzca la fecha de salida con el formato dd/mm/aaaa: ");
					fechaSalida = sc.nextLine();
					
					try {
					    reser.setFechaSalida(fechaSalida);
					    System.out.println("Fecha de salida establecida correctamente.");
					    
					    break;
					} catch (DateTimeParseException e) {
					    System.out.println("Error: El formato de fecha no es válido. Use dd/mm/aaaa.");
					} catch (ImpossibleDateException e) {
					    System.out.println("Error lógico: " + e.getMessage());
					}
				}
				
				reserva.anadirReserva(new Reserva(codigo, nombreCliente, numHabitacion, fechaEntrada, fechaSalida));
			}
			case 2 -> {
				codigo = comprobarNumero("Introduzca el codigo de la reserva que busca: ");
				
				if (!reserva.buscarReserva(codigo)) {
					System.out.println("La reserva que busca no esta registrada, lo sentimos");
				}
			}
			case 3 -> {
				System.out.println("Aqui tiene una lista con todas las reservas registradas");
				reserva.listarReservas();
			}
			case 4 -> {
				codigo = comprobarNumero("Introduzca el codigo de la reserva que busca: ");
				
				//Limpia el buffer
				sc.nextLine();
				
				System.out.println("Introduzca la nueva fecha de entrada: ");
				fechaEntrada = sc.nextLine();
				
				System.out.println("Introduzca la nueva fecha de salida: ");
				fechaSalida = sc.nextLine();
				
				if (reserva.modificarReserva(codigo, fechaEntrada, fechaSalida)) {
					System.out.println("Las fechas han sido modificadas con exito");
				} else {
					System.out.println("No se han podido modificar las fechas porque la reserva que usca modificar no esta en el sistema, lo sentimos");
				}
			}
			case 5 -> {
				codigo = comprobarNumero("Introduzca el codigo de la reserva que busca: ");
				
				if (reserva.eliminarReserva(codigo)) {
					System.out.println("Se ha eliminado la reserva correctamente");
				} else {
					System.out.println("No se ha podido eliminar la reserva buscada porque dichga reserva no esta registrada");
				}
			}
			case 6 -> {
				if (reserva.guardarReserva()) {
					System.out.println("Se han guardado todas las reservas registradas correctamente");
				} else {
					System.out.println("No se puede guardar reserva alguna si no ha anadido ninguna reserva. Intente anadir una");
				}
			}
			case 0 -> {
				System.out.println("Saliendo del sistema...");
			}
			default -> {
				System.out.println("La opcion introducida no esta en el menu. Introduzca una opcion disponible en el menu");
			}
			}
		} while (opcion != 0);

	}
	
	static void mostrarMenu() {
		System.out.println("===MENU DE OPCIONES===");
		System.out.println("1. Añadir reserva");
		System.out.println("2. Buscar reserva");
		System.out.println("3. Listar reservas");
		System.out.println("4. Modificar reserva");
		System.out.println("5. Eliminar reserva");
		System.out.println("6. Guardar");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Elija una opcion del menu (1-7): ");
	}
	
	/**
	 * Comprueba que el numero insertado no sea negativo
	 * @param mensaje
	 * @return El numero si este es positivo
	 */
	static int comprobarNumero(String mensaje) {
	    while (true) {
	        try {
	            System.out.println(mensaje);
	            int valor = sc.nextInt();
	            if (valor <= 0) {
	                throw new NegativeNumberException("El número debe ser positivo.");
	            }
	            return valor;
	        } catch (NegativeNumberException e) {
	            System.out.println("ERROR: " + e.getMessage());
	        }
	    }
	}
	
	/**
	 * Comprueba que la String insertada no sea nula ni este vacia
	 * @param mensaje
	 * @return la String si tiene valor no nulo
	 */
	static String comprobarString(String mensaje) {
	    while (true) {
	        try {
	            System.out.println(mensaje);
	            String nombre = sc.nextLine();
	            if (nombre == null || nombre.isBlank()) {
	    			throw new IllegalArgumentException("Debe introducir el nombre del cliente que ha reservado");
	    		}
	            return nombre;
	        } catch (IllegalArgumentException e) {
	            System.out.println("ERROR: " + e.getMessage());
	        }
	    }
	}
	

}
