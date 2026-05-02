package boletin02ejercicio01;

import java.io.*;
import java.util.Scanner;

public class MainCarta {

	public static void main(String[] args) {
		//Numero de caracteres del archivo
		int numCaracteres = 0;
		
		//Numero de palabras
		int numPalabras = 0;
		
		//Numero de lineas
		int numLineas = 0;
		
		try {
			Scanner sc = new Scanner(new FileReader("/home/deck/git/Unit6/Unit6/src/boletin02ejercicio01/Carta"));
			
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				numLineas++;
				
				//EL numero de caracteres sera igual a la longitud de la linea (incluye los espacios)
				numCaracteres += linea.length();
				
				//SI la linea, despues de haberle quitado los espacios de principio y fin (si tuviera) no estuviese vacia
				if (!(linea.trim().isEmpty())) {
					//Creamos un array que contendra las palabras de la linea (las obtenemos mediante el split, que no tiene en cuenta el espacio especificado en los parentesis)
					String palabras[] = linea.trim().split(" ");
					//El numero de palabras sera igual a la longitud de ese array
					numPalabras += palabras.length;
				}
			}
			
			System.out.println("Lineas: " + numLineas);
			System.out.println("Palabras: " + numPalabras);
			System.out.println("Caracteres: " + numCaracteres);
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

	}

}
