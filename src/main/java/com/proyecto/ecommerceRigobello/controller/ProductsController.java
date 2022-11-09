package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/products")
@RestController
public class ProductsController {

    @Autowired
    private ProductsServiceImpl productsService;

    @PostMapping("/")
    public ProductsModel create (@RequestBody ProductsModel product) throws Exception{ return this.productsService.create(product); }
    @GetMapping("/")
    public List<ProductsModel> findAll(){ return this.productsService.findAll();}
    @PutMapping("/{id}")
    public ProductsModel update (@RequestBody ProductsModel productUpdate, @PathVariable Long id) throws Exception {return this.productsService.update(productUpdate,id);}
    @GetMapping("/{id}")
    public ProductsModel findById(@PathVariable long id) throws Exception { return this.productsService.findById(id); }
    @GetMapping("/sku/{sku}")
    public ProductsModel findBySku(@PathVariable String sku) throws Exception { return this.productsService.findBySku(sku);}

}
