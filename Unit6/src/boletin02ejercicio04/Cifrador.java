package boletin02ejercicio04;

import java.io.*;

public class Cifrador {

	public static void main(String[] args) {
		
		char abecedario[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		//Contendrá la letra que corresponde a cada letra del abecedario
		char codec[] = new char[abecedario.length];
		
		//El mensaje en forma de String
		String mensajeCodificar;
		
		//El array que contiene el mensaje, todavía sin codificar
		char mensajeTabla[];
		
		String letrasCifrado;
		
		try (BufferedReader brCodec = new BufferedReader(new FileReader("src/boletin02ejercicio04/codec"));
			BufferedReader brMensaje = new BufferedReader(new FileReader("src/boletin02ejercicio04/MensajeSinCifrar"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/boletin02ejercicio04/MensajeCifrado", true))){
			
			//Guardamos el cifrado en un String, quitando los espacios
			letrasCifrado = brCodec.readLine().replace(" ", "");
			
			/*
			 * Guardamos el String que contendrá el mensaje
			 * Le quitamos los espacios al mensaje y pasamos todas las letras a minúsculas
			 */
			mensajeCodificar = brMensaje.readLine().toLowerCase().trim();
			
			//Guardamos los caracteres del mensaje en un array
			mensajeTabla = mensajeCodificar.toCharArray();
			
			//Llenamos la tabla del cifrado con los caracteres contenidos en letrasCifrado
			for (int i = 0; i < letrasCifrado.length(); i++) {
				codec[i] = letrasCifrado.charAt(i);
			}
			
			//Cambiamos cada caracter del mensaje por su cifrado
			for (int i = 0; i < mensajeCodificar.length(); i++) {
				mensajeTabla[i] = code(abecedario, codec, mensajeTabla[i]);
			}
			
			bw.write(mensajeTabla);
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}
	
	public static char code (char abecedario[], char codec[], char c) {
		//El indice del lugar donde se encontrará la letra a reemplazar
		int searchedIndex = 0;
				
		//Bucamos el valor del char c en el abecedario
		while (searchedIndex < abecedario.length && c != abecedario[searchedIndex]) {
			searchedIndex++;
		}
				
		//Una vez encontrada la letra, se le asigna el cifrado que le corresponde
		if (searchedIndex < abecedario.length) {
			c = codec[searchedIndex];
		} 
				
		return c;
	}

}
