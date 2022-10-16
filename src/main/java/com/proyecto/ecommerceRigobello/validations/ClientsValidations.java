package com.proyecto.ecommerceRigobello.validations;


import com.proyecto.ecommerceRigobello.model.ClientsModel;

public class ClientsValidations {

    public static boolean checkFields(ClientsModel clientModel, String err){
        if ((clientModel.getDni().isBlank()) || (clientModel.getDni() == null) || (clientModel.getDni().isEmpty())){
            err = "Completa el campo Dni";
            return true;
        }
        if ((clientModel.getName().isBlank()) || (clientModel.getName() == null) || (clientModel.getName().isEmpty())){
            err = "Completa el campo Name";
            return true;
        }
        if ((clientModel.getLastname().isBlank()) || (clientModel.getLastname() == null) || (clientModel.getLastname().isEmpty())){
            err = "Completa el campo Lastname";
            return true;
        }
        if ((clientModel.getBirth_date().isBlank()) || (clientModel.getBirth_date() == null) || (clientModel.getBirth_date().isEmpty())){
            err = "Completa campo Bith date";
            return true;
        }
       return false;
    }





}
