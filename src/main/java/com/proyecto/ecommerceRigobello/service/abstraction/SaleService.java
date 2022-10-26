package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.model.response.SaleResponse;

public interface SaleService {
    SaleResponse findById(Long id) throws Exception;
}
