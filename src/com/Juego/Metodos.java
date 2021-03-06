package com.Juego;

import Librerias.libreria;
import com.Excepciones.NuestrasExcepciones;
import com.Ganadores.FicheroGanadores;

import java.util.Scanner;

public class Metodos {

    public static void opciones() throws NuestrasExcepciones {


        Scanner entrada = new Scanner(System.in);


        String[] botones = {"Jugar = 1", "Mostrar Ganadores = 2", "Salir = 3"};
        System.out.println("Elige tu opcion:" + "\n" + botones[0] + "\n" + botones[1] + "\n" + botones[2]);
        int ventana = entrada.nextInt();

        switch (ventana) {
            case 1:
                jugar();
                break;
            case 2:
                FicheroGanadores gano = new FicheroGanadores();
                System.out.println("\n ");
                gano.leerArchivoGanadores();
                System.out.println("\n ");
                opciones();
            case 3:
                System.out.println("\n Gracias por jugar \n");
                break;
            default:
                throw new NuestrasExcepciones("  Escribe bien la opcion");

        }


    }

    public static void jugar() throws NuestrasExcepciones {

        //creamos las variables
        char J1 = 'x';
        char J2 = 'O';
        char vacio = '-';
        boolean turno = true;

        // turno actual
        // turno=J1=true;

        //creamos matriz tablero donde vamos a jugar de 3 filas y 3 columnas
        char[][] tablero = new char[3][3];
        System.out.flush();
        // rellenamos matriz con los guiones
        libreria.rellenarMatriz(tablero, vacio);

        int fila, columna;
        boolean posValida, correcto;

        while (!finPartida(tablero, vacio)) {

            do {
                //muestra a que jugador le toca  J1,J2
                libreria.mostrarTurnoActual(turno);

                //muestra el tablero
                libreria.mostrarMatriz(tablero);

                correcto = false;
                System.out.flush();

                fila = libreria.pedirInteger("Escribe el numero de la fila");
                columna = libreria.pedirInteger("Escribe el numero de la columna");

                fila = fila - 1;
                columna = columna - 1;
                //validamos la posicion
                posValida = libreria.validarPosicion(tablero, fila, columna);

                if (posValida) {

                    if (!libreria.hayValorPosicion(tablero, fila, columna, vacio)) {
                        correcto = true;

                    } else {
                        System.out.println("Esta posicion ya esta ocupada");
                        System.out.println(" \n");
                    }
                } else {
                    System.out.println("La posicion no es valida se sale del tablero");
                    System.out.println(" \n");
                }
                //mientras no sea correcto se repetira y no saldra


            } while (!correcto);

            if (turno) {
                libreria.insertarEn(tablero, fila, columna, J1);
            } else {
                libreria.insertarEn(tablero, fila, columna, J2);
            }
            //Con esto cambiamos el tuno entre jugador 1 y 2
            turno = !turno;


        }
        //Mostrar tablero
        libreria.mostrarMatriz(tablero);

        //Mostramos el ganador
        mostrarGanador(tablero, J1, J2, vacio);


        // String c="hoila";
        String c = mostrarGanadortxt(tablero, J1, J2, vacio);

        FicheroGanadores ganador = new FicheroGanadores();
        ganador.crearArchivoGanadores();
        ganador.escribirArchivoGanadores(c);

        System.out.println("\n");
        opciones();

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

    public static char coincidenciaLinea(char[][] matriz, char vacio) {

        char simbolo;
        boolean coincidencia;

        for (int i = 0; i < matriz.length; i++) {

            //Reiniciamos la coincidencia
            coincidencia = true;

            //cogemos el simbolo de la fila
            simbolo = matriz[i][0];

            if (simbolo != vacio) {
                for (int j = 1; j < matriz[0].length; j++) {
                    //sino coincide ya no habra ganador en esta fila
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
                //si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        //si no hay ganador, devuelvo el simbolo por defecto
        return vacio;
    }


    public static char coincidenciaColumna(char[][] matriz, char vacio) {

        char simbolo;
        boolean coincidencia;

        for (int i = 0; i < matriz.length; i++) {
            //reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la columna
            simbolo = matriz[0][i];

            if (simbolo != vacio) {
                for (int j = 1; j < matriz[0].length; j++) {
                    //sino coincide ya no habra ganador en esta fila
                    if (simbolo != matriz[j][i]) {
                        coincidencia = false;
                    }
                }
                //si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        //si no hay ganador, devuelvo el simbolo por defecto
        return vacio;
    }


    public static char coincidenciaDiagonal(char[][] matriz, char vacio) {
        char simbolo;
        boolean coincidencia = true;

        //Diagonal principal
        simbolo = matriz[0][0];
        if (simbolo != vacio) {
            for (int i = 1; i < matriz.length; i++) {
                //sino coincide ya no habra ganador en esta fila
                if (simbolo != matriz[i][i]) {
                    coincidencia = false;
                }
            }
            //si no se mete en el if,devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }
        //diagonal inversa
        simbolo = matriz[0][2];
        if (simbolo != vacio) {
            for (int i = 1, j = 1; i < matriz.length; i++, j--) {
                //sino coincide ya no habra ganador en esta fila
                if (simbolo != matriz[i][j]) {
                    coincidencia = false;
                }
            }
            //si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }

        //Si no hay ganador, devuelvo el simbolo por defecto
        return vacio;


    }

    public static void mostrarGanador(char[][] matriz, char J1, char J2, char vacio) {

        char simbolo = coincidenciaLinea(matriz, vacio);

        if (simbolo != vacio) {

            libreria.ganador(simbolo, J1, J2, 1);
            return;
        }
        simbolo = coincidenciaColumna(matriz, vacio);

        if (simbolo != vacio) {

            libreria.ganador(simbolo, J1, J2, 2);

            return;
        }
        simbolo = coincidenciaDiagonal(matriz, vacio);

        if (simbolo != vacio) {

            libreria.ganador(simbolo, J1, J2, 3);

            return;
        }
        System.out.println("Hay empate");
    }


    public static String mostrarGanadortxt(char[][] matriz, char J1, char J2, char vacio) {

        char simbolo = coincidenciaLinea(matriz, vacio);

        if (simbolo != vacio) {

            return libreria.ganadortxt(simbolo, J1, J2, 1);

        }
        simbolo = coincidenciaColumna(matriz, vacio);

        if (simbolo != vacio) {

            return libreria.ganadortxt(simbolo, J1, J2, 2);


        }
        simbolo = coincidenciaDiagonal(matriz, vacio);

        if (simbolo != vacio) {

            return libreria.ganadortxt(simbolo, J1, J2, 3);


        } else {
            return libreria.ganadortxt(simbolo, J1, J2, 4);
        }
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


