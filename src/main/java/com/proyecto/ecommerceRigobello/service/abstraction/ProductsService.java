package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;

public interface ProductsService {

    ProductsResponse findById(Long id) throws Exception;

    ProductsResponse findBySku(String sku) throws Exception;
}
