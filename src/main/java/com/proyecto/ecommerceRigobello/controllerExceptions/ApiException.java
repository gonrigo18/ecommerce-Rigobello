package com.proyecto.ecommerceRigobello.controllerExceptions;

public class ApiException extends Exception{
    private String message;

    public ApiException(String message) {
        super(message);
    }
}
