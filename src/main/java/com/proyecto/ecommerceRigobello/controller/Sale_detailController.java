package com.proyecto.ecommerceRigobello.controller;

import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.service.Sale_detailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "api/details")
@RestController
public class Sale_detailController {

    @Autowired
    private Sale_detailServiceImpl sale_detailService;

    @PostMapping ("/")
    public Sale_detailModel create (@RequestBody Sale_detailModel detail) throws Exception{ return this.sale_detailService.create(detail);}

    @GetMapping("/")
    public List<Sale_detailModel> findAll(){
        return this.sale_detailService.findAll();
    }

    @GetMapping("/{id}")
    public Sale_detailModel findById(@PathVariable long id) throws Exception { return this.sale_detailService.findById(id);}

}
