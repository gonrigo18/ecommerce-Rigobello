package com.proyecto.ecommerceRigobello.controller;

import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.request.SaleRequest;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import com.proyecto.ecommerceRigobello.service.abstraction.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/sales")
@RestController
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping ("/")
    public ResponseEntity<SaleResponse> create(@RequestBody SaleRequest c) throws ApiException {
        return ResponseEntity.ok(saleService.create(c));
    }

    @GetMapping("/")
    public  ResponseEntity<List<SaleResponse>> findAll(){
        return  ResponseEntity.ok((saleService.findAll()));
    }

}
