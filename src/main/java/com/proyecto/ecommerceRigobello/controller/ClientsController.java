package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.service.ClientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping(path = "api/clients")
@RestController
public class ClientsController {

    @Autowired
    private ClientsServiceImpl clientsService;

    @PostMapping("/")
    public ClientsModel create (@RequestBody ClientsModel client) throws Exception { return this.clientsService.create(client);}
    @GetMapping("/")
    public List<ClientsModel> findAll(){
        return this.clientsService.findAll();
    }
    @GetMapping("/{id}")
    public ClientsModel findById(@PathVariable long id) throws Exception { return this.clientsService.findById(id);}


}
