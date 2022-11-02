package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;
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
    public ResponseEntity <ProductsModel> create (@RequestBody ProductsModel product) throws Exception{
        return new ResponseEntity<>(this.productsService.create(product), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductsModel>> findAll(){
        return new ResponseEntity<>(this.productsService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsModel> update (@RequestBody ProductsModel productUpdate, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.productsService.update(productUpdate,id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductsResponse> findById(@PathVariable long id) throws Exception {
        return new ResponseEntity<>(this.productsService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<ProductsResponse> findBySku(@PathVariable String sku) throws Exception {
        return new ResponseEntity<>(this.productsService.findBySku(sku),HttpStatus.OK);
    }

}
