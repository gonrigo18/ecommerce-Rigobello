package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.model.mappers.SaleMapper;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import com.proyecto.ecommerceRigobello.repository.SaleRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleRepository saleRepository;
    private KafkaProperties.Admin request;

    public SaleModel create(SaleModel newSale) {
        return this.saleRepository.save(newSale);
    }

    public List<SaleModel> findAll() {
        return this.saleRepository.findAll();
    }

    @Override
    public SaleResponse findById(Long id) throws ResourceNotFoundException {
        SaleModel saleBD = this.saleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La venta no existe"));
            return SaleMapper.saleResponse(saleRepository.findById(id).orElseThrow());
    }


}
