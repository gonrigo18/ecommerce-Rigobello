package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.controllerExceptions.NullFieldException;
import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.ClientsModel;
import com.proyecto.ecommerceRigobello.dto.ClientsValidationDTO;
import com.proyecto.ecommerceRigobello.service.ClientsService;
import com.proyecto.ecommerceRigobello.validations.ClientsValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RequestMapping(path = "api/clients") // direccion raiz
@RestController
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @PostMapping("/") // metodo post
    public ResponseEntity<ClientsModel> create (@RequestBody ClientsModel client) throws NullFieldException {
        ClientsValidationDTO flag = ClientsValidations.checkFields(client);
        if (flag.hasError){
            throw new NullFieldException(flag.Message);
        }
        return new ResponseEntity<>(this.clientsService.create(client), HttpStatus.OK);
    }

    @GetMapping("/") // metodo get
    public ResponseEntity<List<ClientsModel>> findAll(){
        return new ResponseEntity<>(this.clientsService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClientsModel>> findById(@PathVariable long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.clientsService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientsModel> update (@RequestBody ClientsModel clienstUpdate, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.clientsService.update(clienstUpdate,id), HttpStatus.OK);
    }




}
