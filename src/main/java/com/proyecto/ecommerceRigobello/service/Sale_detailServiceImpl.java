package com.proyecto.ecommerceRigobello.service;


import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.repository.Sale_detailRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.Sale_detailService;
import com.proyecto.ecommerceRigobello.validators.Sale_detailValidations;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class Sale_detailServiceImpl implements Sale_detailService{

    @Autowired
    private Sale_detailRepository sale_detailRepository;
    @Autowired
    private Sale_detailValidations sale_detailValidations;

    @Override
    public Sale_detailModel findById(Long id) throws ResourceNotFoundException {
        this.sale_detailValidations.checkId(id);
        Optional<Sale_detailModel> detail = this.sale_detailRepository.findById(id);
        if(detail.isPresent()) {
            return detail.get();
        }
        else {
            throw new ResourceNotFoundException("No hay detalle");
        }
    }

    @Override
    public List<Sale_detailModel> findDetailBySaleId(Long saleId) throws ResourceNotFoundException {
        List<Sale_detailModel> detail = this.sale_detailRepository.findDetailBySaleId(saleId);
        this.sale_detailValidations.checkList(detail);
        return detail;
    }

    @Override
        public List<Sale_detailModel> findAll() throws ResourceNotFoundException {
        List<Sale_detailModel> detail= this.sale_detailRepository.findAll();
        this.sale_detailValidations.checkList(detail);
        return detail;
    }
    @Override
    public Sale_detailModel create(Sale_detailModel detail) {
        this.sale_detailValidations.check(detail);
        return this.sale_detailRepository.save(detail);
    }

}