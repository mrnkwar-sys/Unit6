package ejercicio08;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class MainEstacionMeteorologica {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		try {
			BufferedWriter in = new BufferedWriter(new FileWriter("C:\\Users\\mr.nkwar\\git\\Unit6\\Unit6\\src\\ejercicio08\\EstacionMeteorologica", true));
			
			//Opcion elegida por el usuario
			int opcion;
			
			//Temperatura máxima registrada
			double maxTemperaturaDia;
			
			//Temperatura minima registrada
			double minTemperaturaDia;
			
			//Fecha en la que se ha registrado la temperatura
			LocalDate fecha = LocalDate.now();
			
			//Se muestra el menú con todas las opciones
			mostrarMenu();
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch(opcion) {
			case 1 -> {
				System.out.println("Introduzca la temperatura máxima del día: ");
				maxTemperaturaDia = sc.nextDouble();
				
				System.out.println("Introduzca la temperatura mínima del día: ");
				minTemperaturaDia = sc.nextDouble();
				
				in.write("Fecha: " + fecha + " | Temperatura máxima: " + maxTemperaturaDia + " | Temperatura mínima: " + minTemperaturaDia);
			}
			case 2 -> {
				
			}
			}

		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	static void mostrarMenu() {
		System.out.println("1. Registra nueva temperatura");
		System.out.println("2. Mostrar historial de registros");
		System.out.println("3. Salir");
		System.out.println("Elija una opción del menú: ");
	}

}
