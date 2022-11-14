package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.controllerExceptions.ClientAlreadyExistsException;
import com.proyecto.ecommerceRigobello.controllerExceptions.NullFieldException;
import com.proyecto.ecommerceRigobello.dto.ClientsValidationsDTO;
import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.request.ClientsRequest;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;
import com.proyecto.ecommerceRigobello.service.abstraction.ClientsService;
import com.proyecto.ecommerceRigobello.validators.ClientsValidations;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping(path = "api/clients")
@RestController
@RequiredArgsConstructor
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @PostMapping("/")
    public ResponseEntity<ClientsResponse> create (@RequestBody ClientsRequest client) throws Exception {
        ClientsValidationsDTO flag = ClientsValidations.checkFields(client);
        if (flag.hasError){
            throw new NullFieldException(flag.Message);
        }
        return ResponseEntity.ok(clientsService.create(client));
    }
    @GetMapping("/")
    public ResponseEntity<List<ClientsResponse>> findAll(){
        return ResponseEntity.ok(clientsService.findAll());
    }
    @GetMapping("/{dni}")
    public ResponseEntity<ClientsResponse> findByDni(@PathVariable Long dni) throws ApiException  {
        return ResponseEntity.ok(clientsService.findByDni(dni));
    }




}
