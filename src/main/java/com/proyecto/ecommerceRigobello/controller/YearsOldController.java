package com.proyecto.ecommerceRigobello.controller;



import com.proyecto.ecommerceRigobello.model.ClientModel;
import com.proyecto.ecommerceRigobello.model.YearsModel;
import com.proyecto.ecommerceRigobello.service.ClientService;
import com.proyecto.ecommerceRigobello.service.YearsOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping (path = "api/years")
@RestController
public class YearsOldController {

    @Autowired
    private YearsOldService yearsOldService;


    @GetMapping("/{id}") // metodo get por id
    public ResponseEntity<Optional<YearsModel>> findById(@PathVariable long id){
        return new ResponseEntity<>(this.yearsOldService.findById(id), HttpStatus.OK);
    }



}
