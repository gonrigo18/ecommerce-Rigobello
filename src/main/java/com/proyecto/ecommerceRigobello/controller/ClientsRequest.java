package com.proyecto.ecommerceRigobello.controller;



import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.dto.ClientDto;
import com.proyecto.ecommerceRigobello.service.YearsOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping (path = "api/years")
@RestController
public class ClientsRequest {

    @Autowired
    private YearsOldService yearsOldService;


    @GetMapping("/{id}") // metodo get por id
    public ResponseEntity<Optional<ClientDto>> findById(@PathVariable long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.yearsOldService.calculateYears(id), HttpStatus.OK);
    }



}
