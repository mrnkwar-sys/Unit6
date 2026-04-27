package ejercicio02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainEntero {

	public static void main(String[] args) {
		int suma = 0;
		double media = 0;
		int contador = 0;
		try {
			Scanner sc = 
					new Scanner(new FileReader("C:\\Users\\mr.nkwar\\git\\Unit6\\Unit6\\src\\ejercicio02\\Enteros"));
			
			do {
				suma += sc.nextInt();
				contador++;
			} while (sc.hasNext());
			
			media = (double) suma/contador;
			
			System.out.println("Resultado suma: " + suma);
			System.out.println("Resultado media: " + media);
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

}
