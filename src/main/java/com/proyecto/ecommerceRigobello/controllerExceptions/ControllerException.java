package com.proyecto.ecommerceRigobello.controllerExceptions;


import com.proyecto.ecommerceRigobello.model.ClientsModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {

     @ExceptionHandler ({ResourceNotFoundException.class})
     public ResponseEntity<String> resourceNotFoundException (Exception e){
         return new ResponseEntity<>("El cliente no existe", HttpStatus.NOT_FOUND);
     }

    @ExceptionHandler ({NullFieldException.class})
     public ResponseEntity<String> nullFieldException (Exception e){
         return new ResponseEntity<>(e.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);
     }


}
