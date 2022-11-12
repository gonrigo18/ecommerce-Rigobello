package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.model.request.Sale_detailRequest;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;

public interface Sale_detailService {

    Sale_detailResponse addToCart(Sale_detailRequest dp) throws ApiException;
}
