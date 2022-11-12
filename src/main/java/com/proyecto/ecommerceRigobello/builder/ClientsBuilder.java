package com.proyecto.ecommerceRigobello.builder;

import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.model.request.ClientsRequest;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ClientsBuilder {

    public static ClientsResponse entityToResponse(ClientsModel client) {
        return ClientsResponse.builder()
                .dni(client.getDni())
                .name(client.getName())
                .lastname(client.getLastname())
                .high_Date(client.getHigh_date())
                .build();
    }

    public static ClientsModel ResponseToEntity(ClientsResponse client) {
        return ClientsModel.builder()
                .dni(client.getDni())
                .name(client.getName())
                .lastname(client.getLastname())
                .high_date(client.getHigh_Date())
                .build();
    }


    public static List<ClientsResponse> entityToResponseList(List<ClientsModel> entityList) {
        return entityList.stream()
                .map(ClientsBuilder::entityToResponse)
                .collect(Collectors.toList());
    }

    public static ClientsModel requestToEntity(ClientsRequest client) {
        return ClientsModel.builder()
                .name(client.getName())
                .lastname(client.getLastname())
                .dni(client.getDni())
                .high_date(null)
                .build();
    }
}
