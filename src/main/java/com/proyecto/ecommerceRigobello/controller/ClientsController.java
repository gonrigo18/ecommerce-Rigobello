package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.model.ClientsModel;
import com.proyecto.ecommerceRigobello.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/clients") // direccion raiz
@RestController
public class ClientsController {

    @Autowired
    private ClientsService clientService;

    @PostMapping("/") // metodo post
    public ResponseEntity<ClientsModel> create (@RequestBody ClientsModel client){
        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.OK);
    }

    @GetMapping("/") // metodo get
    public ResponseEntity<List<ClientsModel>> findAll(){
        return new ResponseEntity<>(this.clientService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientsModel> update (@RequestBody ClientsModel clientUpdate, @PathVariable Long id){
        return new ResponseEntity<>(this.clientService.update(clientUpdate,id), HttpStatus.OK);
    }

}
