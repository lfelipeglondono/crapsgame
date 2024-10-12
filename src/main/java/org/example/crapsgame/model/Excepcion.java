package org.example.crapsgame.model;

public class Excepcion  extends Exception{

    public Excepcion(){
        super();
    }
    public Excepcion (String message){
        super(message);
    }
    public Excepcion(String message, Throwable cause){
        super(message, cause);
    }
    public Excepcion(Throwable cause){
        super();
    }

}