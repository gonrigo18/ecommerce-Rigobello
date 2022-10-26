package com.proyecto.ecommerceRigobello.controller;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;
import com.proyecto.ecommerceRigobello.service.Sale_detailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/details")
@RestController
public class Sale_detailController {

    @Autowired
    private Sale_detailServiceImpl sale_detailService;

    @PostMapping ("/")
    public ResponseEntity<Sale_detailModel> create (@RequestBody Sale_detailModel detail){
        return new ResponseEntity<>(this.sale_detailService.create(detail), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Sale_detailModel>> findAll(){
        return new ResponseEntity<>(this.sale_detailService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale_detailResponse> findById(@PathVariable long id) throws Exception {
        return new ResponseEntity<>(this.sale_detailService.findById(id),HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Sale_detailModel> update (@RequestBody Sale_detailModel detailUpdate, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.sale_detailService.update(detailUpdate,id), HttpStatus.OK);
    }

}
