package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.model.mappers.Sale_detailMapper;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;
import com.proyecto.ecommerceRigobello.repository.Sale_detailRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.Sale_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Sale_detailServiceImpl implements Sale_detailService{

        @Autowired
    Sale_detailRepository sale_detailRepository;

        public Sale_detailModel create(Sale_detailModel newDetail){
            return this.sale_detailRepository.save(newDetail);
        }
        public List<Sale_detailModel> findAll(){
            return this.sale_detailRepository.findAll();
        }

        @Override
        public Sale_detailResponse findById(Long id) throws Exception {
            Sale_detailModel detailDB = this.sale_detailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El detalle no existe"));
            return Sale_detailMapper.detailResponse(sale_detailRepository.findById(id).orElseThrow());
        }
        public Sale_detailModel update(Sale_detailModel detail, Long id) throws Exception {
            Sale_detailModel detailDB = this.sale_detailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El detalle no existe"));
            detailDB.setSale(detail.getSale());
            detailDB.setProducts(detail.getProducts());
            detailDB.setSubtotal(detail.getSubtotal());
            detailDB.setQuantity(detail.getQuantity());
            return this.sale_detailRepository.save(detailDB);
        }

    }

