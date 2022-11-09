package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.mappers.SaleMapper;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import com.proyecto.ecommerceRigobello.model.entities.*;
import com.proyecto.ecommerceRigobello.repository.ClientsRepository;
import com.proyecto.ecommerceRigobello.repository.ProductsRepository;
import com.proyecto.ecommerceRigobello.repository.SaleRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleRepository saleRepository;
    @Autowired
    ClientsRepository clientsRepository;
    @Autowired
    ProductsRepository productsRepository;

    public SaleModel create(SaleModel newSale) {
        return this.saleRepository.save(newSale);
    }
    public List<SaleModel> findAll() {
        return this.saleRepository.findAll();
    }

    @Override
    public SaleResponse findById(Long id) throws Exception {
        return SaleMapper.saleResponse(saleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La venta no existe")));
    }
}

