package com.proyecto.ecommerceRigobello.controller;

import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.request.Sale_detailRequest;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;
import com.proyecto.ecommerceRigobello.repository.Sale_detailRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.Sale_detailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/details")
@RestController
@RequiredArgsConstructor
public class Sale_detailController {

    @Autowired
    private Sale_detailRepository sale_detailRepository;
    private final Sale_detailService sale_detailService;


    @PostMapping ("/")
    public ResponseEntity<Sale_detailResponse> addToCart(@RequestBody Sale_detailRequest dp) throws ApiException {
        return ResponseEntity.ok(sale_detailService.addToCart(dp));
    }

    @GetMapping("/")
    public ResponseEntity<List<Sale_detailResponse>> findAll(){
        return ResponseEntity.ok(sale_detailService.findAll());
    }


}
