package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Memoria {

	private String nombre = "Memoria.txt"; //direccion del archivo persistente
	public Memoria() {
	}
	public void crear() throws IOException {//verifica si ya esta memoria, si no entoces crea el txt
		File archivo = new File(nombre);
		boolean v = archivo.exists();
		if (v == false) {
			archivo.createNewFile();
        } 
	}
	public void ingresar(String texto) throws IOException { //ingresa datos en formato string
		FileWriter archivo = new FileWriter(nombre, true);
		BufferedWriter escribir = new BufferedWriter(archivo);
		escribir.newLine();
        escribir.write(texto);
        escribir.flush();
        escribir.close();
        archivo.close();
	}
	public String sacar() throws IOException { //extrae los datos en formato string en una sola cadena
		StringBuilder info = new StringBuilder();
        FileReader archivo = new FileReader(nombre);
        BufferedReader leer = new BufferedReader(archivo);
        String linea;
        while ((linea = leer.readLine()) != null) {
            info.append(linea).append("\n");
        }
        leer.close();
        archivo.close();
        return info.toString();
	}

}
