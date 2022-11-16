package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.service.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path = "api/products")
public class ProductsController {

    @Autowired
    private  ProductsServiceImpl productsService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) throws Exception {
        return new ResponseEntity<>(productsService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findBySku/{sku}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findBySku(@PathVariable(name = "sku") String sku) throws Exception  {
        return new ResponseEntity<>(productsService.findBySku(sku), HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<ProductsModel>> findAll() throws Exception {
        return new ResponseEntity<>(productsService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> create(@RequestBody ProductsModel newProduct) throws Exception {
        return new ResponseEntity<>(productsService.create(newProduct),HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@RequestBody ProductsModel product, @PathVariable(name = "id") Long id) throws Exception {
        return new ResponseEntity<>(productsService.update(product, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) throws Exception {
        String wanted = productsService.deleteById(id);
        if(wanted.equals("ok"))
            return new ResponseEntity<>("Producto eliminado.", HttpStatus.OK);
        else
            return new ResponseEntity<>("Error al eliminar cliente", HttpStatus.BAD_REQUEST);
    }

}
