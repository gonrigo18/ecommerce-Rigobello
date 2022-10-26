package com.proyecto.ecommerceRigobello.controller;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import com.proyecto.ecommerceRigobello.service.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/sales")
@RestController
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    @PostMapping ("/")
    public ResponseEntity<SaleModel> create (@RequestBody SaleModel sale){
        return new ResponseEntity<>(this.saleService.create(sale), HttpStatus.OK);
    }

    @GetMapping ("/")
    public ResponseEntity <List<SaleModel>> findAll(){
        return new ResponseEntity<>(this.saleService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponse> findById(@PathVariable long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.saleService.findById(id),HttpStatus.OK);
    }


}
