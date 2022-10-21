package com.proyecto.ecommerceRigobello.service.abstraction;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.response.ClientsYearsResponse;

public interface ClientsService {
      ClientsYearsResponse findById(Long id) throws ResourceNotFoundException;

}
