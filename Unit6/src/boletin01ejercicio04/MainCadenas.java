package boletin01ejercicio04;

import java.io.*;
import java.util.Scanner;

public class MainCadenas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String palabraIntroducida;
		try{
			BufferedWriter in = new BufferedWriter(new FileWriter("C:\\Users\\mr.nkwar\\git\\Unit6\\Unit6\\src\\boletin01ejercicio04\\Cadenas"));
			
			do {
				System.out.println("Introduzca una palabra: ");
				palabraIntroducida = sc.next();
				in.write(palabraIntroducida);
				in.newLine();
			} while (!(palabraIntroducida.equalsIgnoreCase("fin")));
			
			in.close();
			sc.close();
		} catch (IOException e) {
			e.getMessage();
		}

	}

}
