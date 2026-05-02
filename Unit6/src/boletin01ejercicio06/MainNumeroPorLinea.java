package boletin01ejercicio06;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainNumeroPorLinea {

	public static void main(String[] args) throws IOException {
		//La lista que va a contener los numeros del archivo
		ArrayList <Integer> listaNumeros = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new FileReader("/home/deck/git/Unit6/Unit6/src/boletin01ejercicio06/NumeroPorLinea"));
			
			while(sc.hasNextInt()) {
				listaNumeros.add(sc.nextInt());
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		
		//Ordenamos los numeros del archivo
		listaNumeros.sort(null);
		
		try {
			BufferedWriter in = new BufferedWriter(new FileWriter("/home/deck/git/Unit6/Unit6/src/boletin01ejercicio06/NumerosOrdenados", true));
			
			for (Integer num : listaNumeros) {
				in.write(String.valueOf(num));
				in.newLine();
			}
			
			in.close();
		} catch (IOException f) {
			f.getMessage();
		}
	}

}
