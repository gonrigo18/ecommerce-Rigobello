package com.proyecto.ecommerceRigobello.validators;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.dto.ClientsValidationsDTO;
import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientsValidations {

    public static void checkFields(ClientsModel clientModel){
        ClientsValidationsDTO response = new ClientsValidationsDTO();
        if (clientModel.getDni() == null){
            response.Message = "Campo Dni vacío, por favor completar";
            response.hasError = true;
            return;
        }

        if ((clientModel.getName().isBlank()) || (clientModel.getName() == null) || (clientModel.getName().isEmpty())){
            response.Message = "Campo Name vacío, por favor completar";
            response.hasError = true;
            return;
        }
        if ((clientModel.getLastname().isBlank()) || (clientModel.getLastname() == null) || (clientModel.getLastname().isEmpty())){
            response.Message = "Campo Lastname vacío, por favor completar";
            response.hasError = true;
            return;
        }
        if (clientModel.getBirth_date() == null){
            response.Message = "Campo Birth date vacío, por favor completar";
            response.hasError = true;
            return;
        }
        response.hasError = false;
    }
    public void validateId(Long id) {
        if (id == null || id < 0)
            throw new IllegalArgumentException("Ingrese un ID válido.");
    }

    public void validateDNI(ClientsModel client) throws ResourceNotFoundException {
        if (client == null)
            throw new ResourceNotFoundException("No existe un cliente con ese DNI.");
    }
    public void checkList(List<ClientsModel> clients) throws ResourceNotFoundException {
        if (clients == null || clients.isEmpty())
            throw new ResourceNotFoundException("No hay clientes en la Base.");
    }
}
