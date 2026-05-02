package boletin02ejercicio03;

import java.io.*;
import java.util.Scanner;

public class MainTextoPocoAPoco {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//Indica que el usuario quiere seguir leyendo la informacion del archivo
		String seguirViendo = "";
		
		try {
			Scanner scan = new Scanner(new FileReader("/home/deck/git/Unit6/Unit6/src/boletin02ejercicio03/TextoPocoAPoco"));
			
			while (!(seguirViendo.equalsIgnoreCase("fin")) && scan.hasNextLine()) {
				for (int i = 0; i <= 3; i++) {
					if (scan.hasNextLine()) {
						System.out.print(scan.nextLine() + " ");
					} else {
						System.out.println();
						System.out.println("Se ha alcanzado el fin del archivo");
						break;
					}
				}
				if (scan.hasNextLine()) {
					System.out.println();
					System.out.println("Si quiere ver mas informacion, introduzca 'more', si no, introduzca 'fin'");
					seguirViendo = sc.nextLine();
				} else {
					seguirViendo = "fin";
				}
			} 
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

	}

}
