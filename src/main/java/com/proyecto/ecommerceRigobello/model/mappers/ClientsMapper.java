package com.proyecto.ecommerceRigobello.model.mappers;

import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;

import java.time.LocalDate;
import java.time.Period;


public class ClientsMapper {


    public static ClientsResponse clientsYears(ClientsModel clients){

        return ClientsResponse.builder()
                .id(clients.getId())
                .name(clients.getName())
                .lastname(clients.getLastname())
                .dni(clients.getDni())
                .birth_date(clients.getBirth_date())
                .years(Period.between(clients.getBirth_date(), LocalDate.now()).getYears())
                .build();
    }
}
