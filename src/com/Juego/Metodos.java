package com.Juego;

import Librerias.libreria;
import com.Excepciones.NuestrasExcepciones;

public class Metodos {

    public static void jugar()throws NuestrasExcepciones {

        //creamos las variables
        char J1='x';
        char J2='O';
        char vacio='-';
        boolean turno=true;

        // turno actual
        // turno=J1=true;

        //creamos matriz tablero donde vamos a jugar de 3 filas y 3 columnas
        char [][] tablero = new char[3][3];

        // rellenamos matriz con los guiones
        //   rellenarMatriz(tablero,vacio);

        int fila,columna;
        boolean posValida,correcto;

        while(!libreria.finPartida(tablero,vacio)){

            do{
                //muestra a que jugador le toca  J1,J2
                libreria.mostrarTurnoActual(turno);

                //muestra el tablero
                libreria.mostrarMatriz(tablero);

                correcto=false;
                fila= libreria.pedirInteger("Escribe el numero de la fila");
                columna=libreria.pedirInteger("Escribe el numero de la columna");
                fila=fila-1;
                columna=columna-1;
                //validamos la posicion
                posValida=libreria.validarPosicion(tablero,fila,columna);

                if(posValida){

                    if(!libreria.hayValorPosicion(tablero,fila,columna,vacio)){
                        correcto=true;
                    }else {
                        throw new NuestrasExcepciones("Esta posicion ya esta ocupada");

                    }

                }else{
                    throw new NuestrasExcepciones("La posicion no es valida se sale del tablero");
                }
                //mientras no sea correcto se repetira y no saldra
            }while (!correcto);

            if(turno){
                libreria.insertarEn(tablero,fila,columna,J1);
            }else {
                libreria.insertarEn(tablero,fila,columna,J2);
            }
            //Con esto cambiamos el tuno entre jugador 1 y 2
            turno=!turno;

            //Mostrar tablero
            libreria.mostrarMatriz(tablero);

            //Mostramos el ganador
            mostrarGanador(tablero,J1,J2,vacio);

        }



        public static boolean matrizLlena(char[][] matriz, char simboloDef) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j] == simboloDef) {
                        return false;
                    }
                }
            }

            return true;

        }


        public static boolean finPartida(char[][] matriz, char simboloDef) {

            if (matrizLlena(matriz, simboloDef)
                    || coincidenciaLinea(matriz, simboloDef) != simboloDef
                    || coincidenciaColumna(matriz, simboloDef) != simboloDef
                    || coincidenciaDiagonal(matriz, simboloDef) != simboloDef) {
                return true;
            }

            return false;
        }


    }

}