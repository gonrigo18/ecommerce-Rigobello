package com.proyecto.ecommerceRigobello.controller;

import com.proyecto.ecommerceRigobello.dto.SaleDTO;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.service.Sale_detailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path = "api/sales")
public class SaleController {
    @Autowired
    private Sale_detailServiceImpl saleService;

    @GetMapping(value = "/")
    public ResponseEntity<List<SaleModel>> findAll() throws Exception {
        return new ResponseEntity<>(saleService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) throws Exception {
        return new ResponseEntity<>(saleService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findByDetailId/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<SaleModel>> findByDetailId(@PathVariable(name = "id") Long id) throws Exception {
        return new ResponseEntity<>(saleService.findByDetailId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/findByClientId/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<SaleModel>> findByClientId(@PathVariable(name = "id") Long id) throws Exception {
        return new ResponseEntity<>(saleService.findByClientId(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<SaleModel> create(@RequestBody SaleDTO newSale) throws Exception {
        return new ResponseEntity<>(saleService.create(newSale), HttpStatus.OK);
    }


}
