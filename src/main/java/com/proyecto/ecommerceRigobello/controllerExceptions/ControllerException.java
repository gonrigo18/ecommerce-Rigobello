package com.proyecto.ecommerceRigobello.controllerExceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerException {


    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Object> illegalArgumentException(Exception ex, WebRequest request)
    {
        return new ResponseEntity<Object>(ex.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceAlreadyExistsException.class})
    public ResponseEntity<Object> resourceAlreadyExistsException(Exception ex, WebRequest request)
    {
        return new ResponseEntity<Object>(ex.toString(), new HttpHeaders(), HttpStatus.FOUND);
    }
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> resourceNotFoundException(Exception ex, WebRequest request)
    {
        return new ResponseEntity<Object>(ex.toString(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler ({NullFieldException.class})
     public ResponseEntity<String> nullFieldException (Exception e){
         return new ResponseEntity<>(e.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);
     }
     @ExceptionHandler({ClientAlreadyExistsException.class})
    public ResponseEntity<String> clientAlreadyExistsException (Exception e){
         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
     }


}
