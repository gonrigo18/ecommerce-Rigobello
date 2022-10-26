package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;
import com.proyecto.ecommerceRigobello.service.ClientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping(path = "api/clients")
@RestController
public class ClientsController {

    @Autowired
    private ClientsServiceImpl clientsService;

    @PostMapping("/")
    public ResponseEntity<ClientsModel> create (@RequestBody ClientsModel client) throws Exception {
        return new ResponseEntity<>(this.clientsService.create(client), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientsModel>> findAll(){
        return new ResponseEntity<>(this.clientsService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientsResponse> findById(@PathVariable long id) throws Exception {
        return new ResponseEntity<>(this.clientsService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientsModel> update (@RequestBody ClientsModel clientsUpdate, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.clientsService.update(clientsUpdate,id), HttpStatus.OK);
    }


}
