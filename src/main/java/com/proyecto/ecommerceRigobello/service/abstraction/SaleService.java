package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.request.SaleRequest;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;

import java.util.List;


public interface SaleService {
    SaleResponse create(SaleRequest c) throws ApiException;

    List<SaleResponse> findAll();
}
