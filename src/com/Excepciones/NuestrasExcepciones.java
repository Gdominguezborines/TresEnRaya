package com.Excepciones;

//AL poner exception le estoy diciendo que es una clase hija de exception asi que ya por eso es una excepcion

import com.Juego.Metodos;

public class NuestrasExcepciones extends Exception {



    public NuestrasExcepciones(String mensaje){
            super(mensaje);
    }


}
