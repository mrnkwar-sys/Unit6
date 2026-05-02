package boletin01ejercicio07;

import java.util.TreeMap;
import java.io.*;
import java.util.Scanner;

public class MainAgenda {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		try {
			BufferedWriter in = new BufferedWriter(new FileWriter("C:\\Users\\mr.nkwar\\git\\Unit6\\Unit6\\src\\boletin01ejercicio07\\Agenda", true));
			
			//Lista que va a contener el número y nombre de los usuarios
			TreeMap<String, Integer> listaAgenda = new TreeMap<>();
					
			//Opcion introducida por el usuario
			int opcion;
			
			//Teléfono del usuario
			int telefono;
			
			//Nombre del usuario
			String nombre;
			
			do {
				//Se muestra el menú
				mostrarMenu();
				opcion = sc.nextInt();
				sc.nextLine();
				
				switch (opcion) {
				case 1 -> {
					System.out.println("Introduzca el número de teléfono del usuario: ");
					telefono = sc.nextInt();
					
					sc.nextLine();
					
					System.out.println("Introduzca el nombre del usuario: ");
					nombre = sc.nextLine();
					
					añadirUsuario(listaAgenda, telefono, nombre);
				}
				case 2 -> {
					System.out.println("Introduzca el nombre del usuario: ");
					nombre = sc.nextLine();
					
					buscarTelefono(listaAgenda, nombre);
				}
				case 3 -> {
					if (listaAgenda.isEmpty()) {
						System.out.println("La agenda está vacía");
					} else {
						for (var entry : listaAgenda.entrySet()) {
						    System.out.println("Nombre: " + entry.getKey() + ", Teléfono: " + entry.getValue());
						}
					}
				}
				case 4 -> {
					for (String key: listaAgenda.keySet()) {
						in.write("Nombre: " + key + " | Teléfono: " + listaAgenda.get(key));
					}
					
					System.out.println("Gracias por utilizar el programa :)");
				}
				default -> {
					System.out.println("Esa opción no existe en el menú");
				}
				}
			} while (opcion != 4);
			
			in.close();
		} catch (IOException e) {
			e.getMessage();
		}
		
	}
	
	static void mostrarMenu() {
		System.out.println("1. Nuevo contacto");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todo");
		System.out.println("4. Salir");
		System.out.println("Elija una de las opciones del menú: ");
	}
	
	static void añadirUsuario(TreeMap<String, Integer> listaAgenda, int telefono, String nombre) {
		if (listaAgenda.size() < 20) {
			listaAgenda.put(nombre, telefono);
			System.out.println("Se ha añadido al usuario a la agenda");
		} else {
			System.out.println("No se pueden añadir más usuarios a la agenda");
		}
	}
	
	static void buscarTelefono(TreeMap<String, Integer> listaAgenda, String nombre) {
		if (listaAgenda.containsKey(nombre)) {
			System.out.println("El teléfono que busca es " + listaAgenda.get(nombre));
		} else {
			System.out.println("El usuario no se encuentra en la agenda");
		}
	}

}
