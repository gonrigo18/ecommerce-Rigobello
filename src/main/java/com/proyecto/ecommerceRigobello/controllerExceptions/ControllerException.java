package com.proyecto.ecommerceRigobello.controllerExceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {

     @ExceptionHandler ({ResourceNotFoundException.class})
     public ResponseEntity<String> resourceNotFoundException (Exception e){
         return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
     }

    @ExceptionHandler ({NullFieldException.class})
     public ResponseEntity<String> nullFieldException (Exception e){
         return new ResponseEntity<>(e.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);
     }
     @ExceptionHandler({ClientAlreadyExistsException.class})
    public ResponseEntity<String> clientAlreadyExistsException (Exception e){
         return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
     }


}
