package com.proyecto.ecommerceRigobello.validators;

import com.proyecto.ecommerceRigobello.dto.ClientsValidationsDTO;
import com.proyecto.ecommerceRigobello.model.request.ClientsRequest;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

public class ClientsValidations {

    public static ClientsValidationsDTO checkFields(ClientsRequest clientModel){
        ClientsValidationsDTO response = new ClientsValidationsDTO();
        if (clientModel.getDni() == null){
            response.Message = "Campo Dni vacío, por favor completar";
            response.hasError = true;
            return response;
        }

        if ((clientModel.getName().isBlank()) || (clientModel.getName() == null) || (clientModel.getName().isEmpty())){
            response.Message = "Campo Name vacío, por favor completar";
            response.hasError = true;
            return response;
        }
        if ((clientModel.getLastname().isBlank()) || (clientModel.getLastname() == null) || (clientModel.getLastname().isEmpty())){
            response.Message = "Campo Lastname vacío, por favor completar";
            response.hasError = true;
            return response;
        }
        if (clientModel.getHigh_date() == null){
            response.Message = "Campo Birth date vacío, por favor completar";
            response.hasError = true;
            return response;
        }
        response.hasError = false;
        return response;
    }
}
