package boletin02ejercicio06;

import java.io.*;

public class MainDeportistas {

	public static void main(String[] args) {
        String nombreMayorEdad = "";
        String nombreMayorPeso = "";
        String nombreMayorEstatura = "";
        int maxEdad = -1;
        double maxPeso = -1.0;
        double maxEstatura = -1.0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/boletin02ejercicio06/Deportistas"))) {
            String linea = br.readLine(); 
            
            while ((linea = br.readLine()) != null) {
                // Suponiendo que los datos están separados por tabuladores o varios espacios
                // El regex "\\s{2,}" detecta dos o más espacios en blanco
                String[] partes = linea.split("\\s{2,}"); 
                
                if (partes.length >= 4) {
                    String nombre = partes[0].trim();
                    int edad = Integer.parseInt(partes[1].trim());
                    // Reemplazamos coma por punto 
                    double peso = Double.parseDouble(partes[2].trim().replace(",", "."));
                    double estatura = Double.parseDouble(partes[3].trim().replace(",", "."));

                    // Encontrar los máximos
                    if (edad > maxEdad) {
                        maxEdad = edad;
                        nombreMayorEdad = nombre;
                    }
                    
                    if (peso > maxPeso) {
                        maxPeso = peso;
                        nombreMayorPeso = nombre;
                    }
                    
                    if (estatura > maxEstatura) {
                        maxEstatura = estatura;
                        nombreMayorEstatura = nombre;
                    }
                }
            }

            System.out.println("Deportista de mayor edad: " + nombreMayorEdad);
            System.out.println("Deportista de mayor peso: " + nombreMayorPeso);
            System.out.println("Deportista de mayor estatura: " + nombreMayorEstatura);

        } catch (IOException | NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}

