package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.model.ClientModel;
import com.proyecto.ecommerceRigobello.model.ClientsModel;
import com.proyecto.ecommerceRigobello.model.YearsModel;
import com.proyecto.ecommerceRigobello.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/client") // direccion raiz
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/") // metodo post
    public ResponseEntity<ClientModel> create (@RequestBody ClientModel client){
        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.OK);
    }

    @GetMapping("/") // metodo get
    public ResponseEntity<List<ClientModel>> findAll(){
        return new ResponseEntity<>(this.clientService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClientModel>> findById(@PathVariable long id){
        return new ResponseEntity<>(this.clientService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientModel> update (@RequestBody ClientModel clientUpdate, @PathVariable Long id){
        return new ResponseEntity<>(this.clientService.update(clientUpdate,id), HttpStatus.OK);
    }

}
