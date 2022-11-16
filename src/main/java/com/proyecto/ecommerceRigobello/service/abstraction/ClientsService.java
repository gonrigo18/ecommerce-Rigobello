package com.proyecto.ecommerceRigobello.service.abstraction;

import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import java.util.List;
import java.util.Optional;

public interface ClientsService {
      public Optional<ClientsModel> findById(Long id) throws Exception;
      public ClientsModel findByDni(String dni) throws Exception;
      public List<ClientsModel> findAll() throws Exception;
      public String create(ClientsModel newClient) throws Exception;
      public String update(ClientsModel client, Long id) throws Exception;
      public String deleteById(Long id) throws Exception;
}
