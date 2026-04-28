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
			
			//Temperaturas máxima y mínima registrada en todo el achivo
			double maxTemp = Integer.MIN_VALUE;
			double minTemp = Integer.MAX_VALUE;
			
			//Fecha en la que se ha registrado la temperatura
			LocalDate fecha = LocalDate.now();
			
			//Variable que definirá si el fichero continúa teniendo contenido o no
			String linea;
			
			do {
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
					
					if (maxTemperaturaDia > maxTemp) {
						maxTemp = maxTemperaturaDia;
					} 
					
					if (minTemperaturaDia < minTemp) {
						minTemp = minTemperaturaDia;
					}
					
					in.write("Fecha: " + fecha + " | Temperatura máxima: " + maxTemperaturaDia + " | Temperatura mínima: " + minTemperaturaDia);
					
					in.newLine();
					in.flush();
					
					System.out.println("Registro guardado");
				}
				case 2 -> {
					try {
						BufferedReader on = new BufferedReader(new FileReader("C:\\Users\\mr.nkwar\\git\\Unit6\\Unit6\\src\\ejercicio08\\EstacionMeteorologica"));
						
						while ((linea = on.readLine()) != null) {
							System.out.println(linea);
						}
						
						System.out.println("Temperatura máxima registrada en el archivo: " + maxTemp);
						System.out.println("Temperatura mínima registrada en el archivo:  " + minTemp);
						
						on.close();
					} catch (IOException e) {
						e.getMessage();
					}
				}
				}
			} while (opcion != 3);

			in.close();
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
