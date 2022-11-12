package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.request.ProductsRequest;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;

import java.util.List;

public interface ProductsService {

    ProductsResponse findBySku(Long id) throws ApiException;
    ProductsResponse findByProductAndQuantity(Long id, int quantity) throws ApiException;
    List<ProductsResponse> findAll();
    ProductsResponse create(ProductsRequest product) throws ApiException;
    ProductsResponse update(ProductsRequest product) throws ApiException;
    void deleteById(Long id)throws ApiException;
    void discountStock (Long id, int quantity) throws ApiException;
}
