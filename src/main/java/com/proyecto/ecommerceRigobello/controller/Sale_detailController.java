package com.proyecto.ecommerceRigobello.controller;

import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.service.Sale_detailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/details")
public class Sale_detailController {

    @Autowired
    private Sale_detailServiceImpl sale_detailService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) throws Exception {
        return new ResponseEntity<>(sale_detailService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getSale_detail/{saleId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Sale_detailModel>> getSale_detail(@PathVariable(name = "saleId") Long saleId) throws Exception {
        return new ResponseEntity<>(sale_detailService.getSale_detail(saleId), HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Sale_detailModel>> findAll() throws Exception {
        return new ResponseEntity<>(sale_detailService.findAll(), HttpStatus.OK);
    }

}
