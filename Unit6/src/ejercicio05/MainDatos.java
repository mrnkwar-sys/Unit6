package ejercicio05;

import java.io.*;
import java.util.Scanner;

public class MainDatos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombre;
		int edad;
		try {
			BufferedWriter in = new BufferedWriter(new FileWriter("C:\\Users\\mr.nkwar\\git\\Unit6\\Unit6\\src\\ejercicio05\\Datos", true));
			
			
			System.out.println("Introduzca un nombre: ");
			nombre = sc.nextLine();
			System.out.println("Introduzca una edad: ");
			edad = sc.nextInt();
			in.write(nombre + " " + edad);
			
			in.close();
		} catch (IOException e) {
			e.getMessage();
		}

		sc.close();
	}

}
