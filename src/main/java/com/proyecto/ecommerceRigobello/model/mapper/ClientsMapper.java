package com.proyecto.ecommerceRigobello.model.mapper;

import com.proyecto.ecommerceRigobello.model.ClientsModel;
import com.proyecto.ecommerceRigobello.model.response.ClientsYearsResponse;

import java.time.LocalDate;
import java.time.Period;

public class ClientsMapper {


    public static ClientsYearsResponse clientsToResponse(ClientsModel clients){

        return ClientsYearsResponse.builder()
                .id(clients.getId())
                .name(clients.getName())
                .lastname(clients.getLastname())
                .dni(clients.getDni())
                .birth_date(clients.getBirth_date())
                .years(Period.between(clients.getBirth_date(), LocalDate.now()).getYears())
                .build();
    }
}
