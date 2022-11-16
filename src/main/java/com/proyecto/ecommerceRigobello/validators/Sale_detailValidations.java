package com.proyecto.ecommerceRigobello.validators;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class Sale_detailValidations {
    public void checkId(Long id){
        if(id == null || id < 0) {
            throw new IllegalArgumentException("ID invalido.");
        }
    }

    public void checkList(List<Sale_detailModel> detail) throws Exception {
        if(detail == null || detail.isEmpty()) {
            throw new ResourceNotFoundException("Detalle no existe");
        }
    }
    public void check(Sale_detailModel detail) {
        if (detail == null) {
            throw new IllegalArgumentException("Sin detalle existente");
        }

        if (detail.getSaleId() == null || detail.getProductId() == null) {
            throw new IllegalArgumentException("No puede haber campos vacios");
        }

        if(detail.getQuantity() < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser menor a 0");
        }
    }
}
