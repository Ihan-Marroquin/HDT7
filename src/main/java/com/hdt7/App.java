package com.hdt7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, String> diccionario = new HashMap<>();

        // Lectura del archivo diccionario.txt y construcción del HashMap
        String rutaArchivoDiccionario = "src/main/java/com/hdt7/diccionario.txt";
        try {
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivoDiccionario));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                String clave = partes[0].trim().substring(1); // Elimina el paréntesis abierto y espacios al inicio
                String valor = partes[1].trim().substring(0, partes[1].trim().length() - 1); // Elimina el paréntesis cerrado y espacios al final
                diccionario.put(clave.toLowerCase(), valor.toLowerCase()); // Convertir a minúsculas para comparaciones insensibles a mayúsculas
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lectura del archivo texto.txt para traducción
        String rutaArchivoTexto = "src/main/java/com/hdt7/texto.txt";
        try {
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivoTexto));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String palabra : palabras) {
                    String palabraLimpia = palabra.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Eliminar caracteres no alfabéticos y convertir a minúsculas
                    if (!palabraLimpia.isEmpty()) {
                        if (diccionario.containsKey(palabraLimpia)) {
                            System.out.print(diccionario.get(palabraLimpia) + " ");
                        } else {
                            System.out.print("*" + palabra + "* ");
                        }
                    }
                }
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Asociacion<K extends Comparable<K>, V> {
    K clave;
    V valor;

    public Asociacion(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }
}