package boletin02ejercicio05;

import java.io.*;

public class CompararArchivos {

	public static void main(String[] args) {
		String linea;
		String linea2;
		int numLinea = 1;
		
		try (BufferedReader brPrimer = new BufferedReader(new FileReader("src/boletin02ejercicio05/ArchivoComparar01"));
			BufferedReader brSegundo = new BufferedReader(new FileReader("src/boletin02ejercicio05/ArchivoComparar02"))){
			
			while ((linea = brPrimer.readLine()) != null) {
				linea2 = brSegundo.readLine();
				
				if (linea2 == null) {
					System.out.println("El segundo archivo es más corto que el primer archivo");
					return;
				}
				
				if (!linea.equals(linea2)) {
					for (int i = 0; i < Math.min(linea.length(), linea2.length()); i++) {
						if (linea.charAt(i) != linea2.charAt(i)) {
							System.out.println("Los archivos son distintos en la línea " + numLinea + ", caracter " + (i+1));
							return;
						}
					}
					System.out.println("Diferencia de longitud en línea " + numLinea);
	                return;
				}
				numLinea++;
			}
			
			if (brSegundo.readLine() != null) {
	            System.out.println("El primer archivo es más corto que el segundo.");
	        } else {
	            System.out.println("Los archivos tienen exactamente el mismo contenido.");
	        }
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

}
