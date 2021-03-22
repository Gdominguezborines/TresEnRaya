package com.Principal;

import com.Excepciones.NuestrasExcepciones;
import com.Ganadores.FicheroGanadores;
import com.Juego.Metodos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class  LlamadaAJuego{

    static Scanner teclado=new Scanner(System.in);

    public static void main(String[] args){



        Metodos juguemos=new Metodos();
        boolean correcto=false;

        do {
     try {
         juguemos.opciones();
         correcto = true;
     }catch (InputMismatchException ex){
         System.out.println("!!!ERROR!!   Escribe un numero por favor ");
         System.out.println(" ");
     }
     catch (NuestrasExcepciones e) {
         System.out.println("!!!ERROR!!! " + e.getMessage());
         System.out.println(" ");

            correcto=false;
     }

 } while (!correcto);


    }
}