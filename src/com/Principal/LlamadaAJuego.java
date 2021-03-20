package com.Principal;

import com.Excepciones.NuestrasExcepciones;
import com.Ganadores.FicheroGanadores;
import com.Juego.Metodos;
import java.util.Scanner;

public class  LlamadaAJuego{

    static Scanner teclado=new Scanner(System.in);

    public static void main(String[] args){


        FicheroGanadores obx = new FicheroGanadores();
        obx.crearArchivoGanadores();
        obx.escribirArchivoGanadores();
        obx.leerArchivoGanadores();

        Metodos juguemos=new Metodos();
        boolean correcto=false;

        do {
     try {
         juguemos.jugar();
         correcto = true;
     }
     catch (NuestrasExcepciones e) {
         System.out.println("!!!ERROR!! " + e.getMessage());
         System.out.println(" ");
         System.out.println(" ");

     }

 } while (!correcto);


    }
}