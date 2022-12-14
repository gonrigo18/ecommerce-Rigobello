package com.proyecto.ecommerceRigobello.controller;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.service.ClientsServiceImpl;
import com.proyecto.ecommerceRigobello.service.abstraction.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/clients")
public class ClientsController {

    @Autowired
    private ClientsServiceImpl clientsService;

    @GetMapping( value= "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(clientsService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findByDni/{dni}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findByDni(@PathVariable(name = "dni") String dni) throws Exception {
        return new ResponseEntity<>(clientsService.findByDni(dni), HttpStatus.OK);
    }
    @GetMapping(value= "/")
    public ResponseEntity<List<ClientsModel>> findAll() throws Exception {
        return new ResponseEntity<>(clientsService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value= "/")
    public ResponseEntity<String> create(@RequestBody ClientsModel newClient) throws Exception {
        return new ResponseEntity<>(clientsService.create(newClient), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@RequestBody ClientsModel client, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(clientsService.update(client, id), HttpStatus.OK);
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        String wanted = clientsService.deleteById(id);
        if(wanted.equals("ok"))
            return new ResponseEntity<>("Cliente eliminado.", HttpStatus.OK);
        else
            return new ResponseEntity<>("Error al eliminar cliente", HttpStatus.BAD_REQUEST);
    }

}
