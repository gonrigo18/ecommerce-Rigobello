package com.proyecto.ecommerceRigobello.controller;


import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.request.ProductsRequest;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;
import com.proyecto.ecommerceRigobello.repository.ProductsRepository;
import com.proyecto.ecommerceRigobello.service.ProductsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "api/products")
@RestController
@RequiredArgsConstructor
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;
    private final ProductsServiceImpl productsService;

    @PostMapping("/")
    public ResponseEntity<ProductsResponse> create(@RequestBody ProductsRequest p) throws ApiException {
        return ResponseEntity.ok(productsService.create(p));
    }
    @GetMapping("/")
    public ResponseEntity<List<ProductsResponse>> findAll() {
        return ResponseEntity.ok(productsService.findAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductsResponse> update(@RequestBody ProductsRequest p) throws ApiException {
        return ResponseEntity.ok(productsService.update(p));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductsResponse> findBySku(@PathVariable Long id) throws ApiException {
        return ResponseEntity.ok(productsService.findBySku(id));
    }

    @GetMapping("/{id}/{quantity}")
    public ResponseEntity<ProductsResponse> findBySkuAndQuantity(@PathVariable Long id, @PathVariable int quantity) throws ApiException {
        return ResponseEntity.ok(productsService.findByProductAndQuantity(id, quantity));
    }
    public void deleteById(@PathVariable Long sku)throws ApiException {
        productsService.deleteById(sku);
    }

}
