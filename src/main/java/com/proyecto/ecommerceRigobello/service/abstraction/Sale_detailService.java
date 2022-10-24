package com.proyecto.ecommerceRigobello.service.abstraction;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;

public interface Sale_detailService {

    Sale_detailResponse findById(Long id) throws ResourceNotFoundException;
}
