package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.service.abstraction.dtos.SaleDTO;

public interface SaleService {
    SaleDTO findById(Long id) throws Exception;
}
