package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.dto.SaleDTO;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import com.proyecto.ecommerceRigobello.saleJson.SaleJson;

public interface SaleService {
    SaleResponse findById(Long id) throws Exception;
    SaleDTO invoiceSale(SaleJson sale) throws Exception;
}
