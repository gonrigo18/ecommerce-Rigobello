package com.proyecto.ecommerceRigobello.controllerExceptions;

public class ClientAlreadyExistsException extends Exception{

    public ClientAlreadyExistsException(String message){
        super(message);
    }
}
