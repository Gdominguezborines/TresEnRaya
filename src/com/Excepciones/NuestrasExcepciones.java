package com.Excepciones;

//AL poner exception le estoy diciendo que es una clase hija de exception asi que ya por eso es una excepcion

public class NuestrasExcepciones extends Exception {


    public NuestrasExcepciones(String mensaje){
        //con super inicializo los atributos de la clase padre
        super(mensaje);
    }

}
