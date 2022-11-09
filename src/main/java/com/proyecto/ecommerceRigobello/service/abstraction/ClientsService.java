package com.proyecto.ecommerceRigobello.service.abstraction;

import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;

public interface ClientsService {
      ClientsModel findById(Long id) throws Exception;

}
