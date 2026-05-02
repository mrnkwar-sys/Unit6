package boletin01ejercicio01;

import java.io.*;
import java.util.Scanner;

public class MainNumerosReales {
	public static void main(String[] args) throws FileNotFoundException {
		int suma = 0;
		double media = 0;
		int contador = 0;
		try {
			Scanner sc = 
					new Scanner(new FileReader("C:\\Users\\mr.nkwar\\git\\Unit6\\Unit6\\src\\boletin01ejercicio01\\NumerosReales"));
			
			do {
				suma += sc.nextInt();
				contador++;
			} while (sc.hasNext());
			
			media = suma/contador;
			
			System.out.println("Resultado suma: " + suma);
			System.out.println("Resultado media: " + media);
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}
}
