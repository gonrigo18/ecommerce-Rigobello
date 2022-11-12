package com.proyecto.ecommerceRigobello.service.abstraction;

import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.request.ClientsRequest;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;
import java.util.List;

public interface ClientsService {
      List<ClientsResponse> findAll();
      ClientsResponse findById (Long id) throws ApiException;

      ClientsResponse create(ClientsRequest client) throws ApiException;

      ClientsResponse findByDni(Long dni) throws ApiException;
}
