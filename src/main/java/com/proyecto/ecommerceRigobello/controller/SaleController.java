package com.proyecto.ecommerceRigobello.controller;

import com.proyecto.ecommerceRigobello.service.abstraction.dtos.SaleDTO;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.service.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "api/sales")
@RestController
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    @PostMapping ("/")
    public SaleModel create (@RequestBody SaleModel sale) throws Exception{ return this.saleService.create(sale);
    }

    @GetMapping ("/")
    public List<SaleModel> findAll(){
        return this.saleService.findAll();
    }

    @GetMapping("/{id}")
    public SaleDTO findById(@PathVariable long id) throws Exception{ return this.saleService.findById(id);}

}
