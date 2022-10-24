package com.proyecto.ecommerceRigobello.service.abstraction;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;

public interface SaleService {
    SaleResponse findById(Long id) throws ResourceNotFoundException;
}
