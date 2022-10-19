package com.proyecto.ecommerceRigobello.model.mapper;

import com.proyecto.ecommerceRigobello.model.ClientsModel;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;

public class ClientsMapper {


    public static ClientsResponse clientsToResponse(ClientsModel clients){

        return ClientsResponse.builder()
                .id(clients.getId())
                .name(clients.getName())
                .lastname(clients.getLastname())
                .dni(clients.getDni())
                .birth_date(clients.getBirth_date())
                .build();
    }

}
