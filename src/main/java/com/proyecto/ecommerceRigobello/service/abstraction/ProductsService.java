package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;

public interface ProductsService {

    ProductsModel findById(Long id) throws Exception;

    ProductsModel findBySku(String sku) throws Exception;
}
