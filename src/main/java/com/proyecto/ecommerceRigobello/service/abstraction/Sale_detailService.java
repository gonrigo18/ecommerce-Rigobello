package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;


import java.util.List;
import java.util.Optional;

public interface Sale_detailService {

    public Sale_detailModel findById(Long id) throws ResourceNotFoundException;
    public List<Sale_detailModel> findDetailBySaleId(Long saleId) throws ResourceNotFoundException;
    public List<Sale_detailModel> findAll() throws ResourceNotFoundException;
    public Sale_detailModel create(Sale_detailModel detail) throws Exception;
}
