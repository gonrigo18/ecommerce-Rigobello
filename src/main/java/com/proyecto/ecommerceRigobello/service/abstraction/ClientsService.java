package com.proyecto.ecommerceRigobello.service.abstraction;

import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;

public interface ClientsService {
      ClientsResponse findById(Long id) throws Exception;

}
