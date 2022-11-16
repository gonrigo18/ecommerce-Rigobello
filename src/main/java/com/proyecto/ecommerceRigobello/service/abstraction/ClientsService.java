package com.proyecto.ecommerceRigobello.service.abstraction;

import com.proyecto.ecommerceRigobello.controllerExceptions.IllegalArgumentException;
import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceAlreadyExistsException;
import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import java.util.List;
import java.util.Optional;

public interface ClientsService {
      public Optional<ClientsModel> findById(Long id) throws ResourceNotFoundException;
      public ClientsModel findByDni(String dni) throws ResourceNotFoundException;
      public List<ClientsModel> findAll() throws ResourceNotFoundException;
      public String create(ClientsModel newClient) throws ResourceAlreadyExistsException;
      public String update(ClientsModel client, Long id) throws ResourceNotFoundException;
      public String deleteById(Long id) throws ResourceNotFoundException, ResourceAlreadyExistsException, IllegalArgumentException;
}
