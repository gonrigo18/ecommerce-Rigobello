package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.dto.SaleDTO;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import java.util.List;
import java.util.Optional;


public interface SaleService {
    public Optional<SaleModel> findById(Long id) throws ResourceNotFoundException;
    public List<Sale_detailModel> findByDetailId(Long id) throws ResourceNotFoundException;
    public List<SaleModel> findAll() throws ResourceNotFoundException;
    public List<SaleModel> findByClientId(Long clientId) throws ResourceNotFoundException;
    public SaleModel create(SaleDTO newSale) throws ResourceNotFoundException;
    public SaleModel update(SaleModel sale, Long id) throws ResourceNotFoundException;
}
