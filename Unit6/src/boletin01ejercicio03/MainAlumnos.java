package boletin01ejercicio03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainAlumnos {

	public static void main(String[] args) {
		String nombre = "";
		int edad = 0;
		double estatura = 0;
		double mediaEdad = 0;
		double mediaEstatura = 0;
		int contador = 0;
		try {
			Scanner sc = 
					new Scanner(new FileReader("C:\\Users\\mr.nkwar\\git\\Unit6\\Unit6\\src\\boletin01ejercicio03\\Alumnos"));
			
			do {
				nombre = sc.next();
				edad += Integer.parseInt(sc.next());
				estatura += Double.parseDouble(sc.next());
				System.out.println("Alumno: " + nombre);
				contador++;
			} while (sc.hasNext());
			
			mediaEdad = (double) edad/contador;
			mediaEstatura = estatura/contador;
			
			System.out.println("Media edad: " + mediaEdad);
			System.out.println("Media estatura: " + mediaEstatura);
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

	}

}
