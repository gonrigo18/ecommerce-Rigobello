package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.dto.SaleDTO;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import java.util.List;
import java.util.Optional;


public interface SaleService {
    public Optional<SaleModel> findById(Long id) throws Exception;
    public List<Sale_detailModel> findByDetailId(Long id) throws Exception;
    public List<SaleModel> findAll() throws Exception;
    public List<SaleModel> findByClientId(Long clientId) throws Exception;
    public SaleModel create(SaleDTO newSale) throws Exception;
    public SaleModel update(SaleModel sale, Long id) throws Exception;
}
