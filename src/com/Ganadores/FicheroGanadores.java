package com.Ganadores;

import java.io.*;

public class FicheroGanadores {


    public void crearArchivoGanadores() {

        File archivo = new File("Ganadores.txt");

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                System.out.println(archivo.getName() + " Ha sido creado");

            } catch (IOException ex) {
                //ex.printStackTrace();
                System.out.println("No se a encontrado el archivo");
            }

        }

    }

    public void escribirArchivoGanadores(String ganador) {


        try {
            FileWriter archivo = new FileWriter("Ganadores.txt", true);

            archivo.write("\r\n" + "El ganador ha sido: " + ganador);
            archivo.close();


        } catch (IOException e) {
            System.out.println("No se a encontrado el archivo");
        }

    }


    public void leerArchivoGanadores() {
        String cadena;
        try {

            FileReader lector = new FileReader("Ganadores.txt");
            BufferedReader lectura = new BufferedReader(lector);

            cadena = lectura.readLine();
            while (cadena != null) {
                System.out.println(cadena);
                cadena = lectura.readLine();
            }


        } catch (FileNotFoundException ex) {
            System.out.println("EROR" + ex);

        } catch (IOException ex) {
            System.out.println("No se a encontrado el archivo" + ex);
        }

    }


}
