package com.proyecto.ecommerceRigobello.controller;



import com.proyecto.ecommerceRigobello.model.ClientModel;
import com.proyecto.ecommerceRigobello.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping (path = "api/years")
@RestController
public class YearsOldController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}") // metodo get
    public ResponseEntity<Optional<ClientModel>> findById(@PathVariable long id){
        return new ResponseEntity<>(this.clientService.findById(id), HttpStatus.OK);
    }




}
