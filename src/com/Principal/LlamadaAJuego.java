package com.Principal;

import com.Excepciones.NuestrasExcepciones;

import com.Juego.Metodos;

import java.util.InputMismatchException;


public class  LlamadaAJuego{



    public static void main(String[] args){



        boolean correcto=false;

        do {
     try {
          Metodos.opciones();
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