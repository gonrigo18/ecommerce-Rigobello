package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;

public interface Sale_detailService {

    Sale_detailModel findById(Long id) throws Exception;
}
