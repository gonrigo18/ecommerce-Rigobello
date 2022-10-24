package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/products")
@RestController
public class ProductsController {

    @Autowired
    private ProductsServiceImpl productsService;

    @PostMapping("/")
    public ResponseEntity <ProductsModel> create (@RequestBody ProductsModel product){
        return new ResponseEntity<>(this.productsService.create(product), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductsModel>> findAll(){
        return new ResponseEntity<>(this.productsService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsModel> update (@RequestBody ProductsModel productUpdate, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.productsService.update(productUpdate,id), HttpStatus.OK);
    }



}
