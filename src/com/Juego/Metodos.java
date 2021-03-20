package com.Juego;

public class Metodos {

    public static char coincidenciaLinea(char[][] matriz, char vacio){

        char simbolo;
        boolean coincidencia;

        for(int i = 0; i< matriz.length;i++){

            //Reiniciamos la coincidencia
            coincidencia = true;

            //cogemos el simbolo de la fila
            simbolo = matriz[i][0];

            if(simbolo != vacio){
                for(int j=1;j<matriz[0].length;j++){
                    //sino coincide ya no habra ganador en esta fila
                    if(simbolo != matriz[i][j]){
                        coincidencia = false;
                    }
                }
                //si no se mete en el if, devuelvo el simbolo ganador
                if(coincidencia){
                    return simbolo;
                }
            }
        }
        //si no hay ganador, devuelvo el simbolo por defecto
        return vacio;
    }
    public static char coincidenciaColumna(char[][] matriz, char vacio){

        char simbolo;
        boolean coincidencia;

        for(int i = 0;i < matriz.length;i++){
            //reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la columna
            simbolo = matriz[0][i];

            if(simbolo != vacio){
                for(int j=1;j<matriz[0].length;j++){
                    //sino coincide ya no habra ganador en esta fila
                    if(simbolo != matriz[i][j]){
                        coincidencia=false;
                    }
                }
                //si no se mete en el if, devuelvo el simbolo ganador
                if(coincidencia){
                    return simbolo;
                }
            }
        }
        //si no hay ganador, devuelvo el simbolo por defecto
        return vacio;
    }
    public static  char coincidenciaDiagonal(char[][] matriz, char vacio){
        char simbolo;
        boolean coincidencia = true;

        //Diagonal principal
        simbolo = matriz[0][0];
        if(simbolo != vacio){
            for(int i=1;i< matriz.length;i++){
                //sino coincide ya no habra ganador en esta fila
                if(simbolo != matriz[i][i]){
                    coincidencia = false;
                }
            }
            //si no se mete en el if,devuelvo el simbolo ganador
            if(coincidencia){
                return simbolo;
            }
        }
        //diagonal inversa
        simbolo = matriz[0][2];
        if(simbolo != vacio){
            for(int i=1,j = 1;i< matriz.length;i++,j--){
                //sino coincide ya no habra ganador en esta fila
                if(simbolo != matriz[i][j]){
                    coincidencia = false;
                }
            }
            //si no se mete en el if, devuelvo el simbolo ganador
            if(coincidencia){
                return simbolo;
            }
        }

        //Si no hay ganador, devuelvo el simbolo por defecto
        return vacio;


    }
    public static void mostrarGanador(char[][] matriz, char J1, char J2, char vacio ){

        char simbolo = coincidenciaLinea(matriz, vacio);

        if(simbolo != vacio){

            libreria.ganador(simbolo, J1, J2, 1);

            return;
        }
        simbolo = coincidenciaColumna(matriz, vacio);

        if(simbolo != vacio){

            libreria.ganador(simbolo, J1, J2, 2);

            return;
        }
        simbolo = coincidenciaDiagonal(matriz, vacio);

        if(simbolo != vacio){

            libreria.ganador(simbolo, J1, J2, 3);

            return;
        }





    }


}
