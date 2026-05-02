package boletin02ejercicio02;

import java.io.*;
import java.util.Scanner;

public class MainFirmas {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//La opcion elegida por el usuario
		int opcion;
		
		//El nombre insertado por el usuario
		String nombre;
		
		do {
			mostrarMenu();
			
			System.out.println("Elija una opcion del menu: ");
			opcion = sc.nextInt();
			
			sc.nextLine();
			
			switch(opcion) {
			case 1 -> {
				try {
					BufferedReader reader = new BufferedReader(new FileReader("/home/deck/git/Unit6/Unit6/src/boletin02ejercicio02/Firmas"));
					
					String linea;
					
			        boolean vacio = true;
			        
			        while ((linea = reader.readLine()) != null) {
			            System.out.println(linea);
			            vacio = false;
			        }
			        
			        if (vacio) {
			        	System.out.println("El libro de firmas está vacío.");
			        }
					
					reader.close();
				} catch (IOException e) {
					e.getMessage();
				}
			}
			case 2 -> {
				System.out.println("Introduzca el nombre que desea insertar en el libro de firmas: ");
				nombre = sc.nextLine();
					
				boolean existe = false;
				
				try {
					Scanner scan = new Scanner(new FileReader("/home/deck/git/Unit6/Unit6/src/boletin02ejercicio02/Firmas"));
					
					while(scan.hasNextLine()) {
						if (scan.nextLine().equalsIgnoreCase(nombre)) {
							existe = true;
							break;
						}
					}
					scan.close();
				} catch (FileNotFoundException e) {
					e.getMessage();
				}
				
				if (!existe) {
					try {
						BufferedWriter in = new BufferedWriter(new FileWriter("/home/deck/git/Unit6/Unit6/src/boletin02ejercicio02/Firmas", true));
						
						in.write(nombre);
						in.newLine();
						
						System.out.println("La firma se ha anadido correctamente");
						
						in.flush();
						in.close();
					} catch (IOException e) {
						e.getMessage();
					}
				} else {
					System.out.println("El nombre ya se encuentra en el libro de firmas");
				}
				
			}
			case 3 ->{
				System.out.println("Gracias por utilizar el programa :)");
			}
			}
		} while (opcion != 3);
		

	}
	
	static void mostrarMenu() {
		System.out.println("1. Mostrar firmas");
		System.out.println("2. Anadir firma");
		System.out.println("3. Salir");
	}

}
