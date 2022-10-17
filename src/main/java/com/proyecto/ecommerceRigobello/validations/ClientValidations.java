package com.proyecto.ecommerceRigobello.validations;


import com.proyecto.ecommerceRigobello.model.ClientsModel;
import com.proyecto.ecommerceRigobello.dto.ClientValidationDTO;

public class ClientValidations {

    public static ClientValidationDTO checkFields(ClientsModel clientModel){
        ClientValidationDTO response = new ClientValidationDTO();
        if ((clientModel.getDni().isBlank()) || (clientModel.getDni() == null) || (clientModel.getDni().isEmpty())){
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
        if ((clientModel.getBirth_date().isBlank()) || (clientModel.getBirth_date() == null) || (clientModel.getBirth_date().isEmpty())){
            response.Message = "Campo Birth date vacío, por favor completar";
            response.hasError = true;
            return response;
        }
        response.hasError = false;
        return response;
    }





}
