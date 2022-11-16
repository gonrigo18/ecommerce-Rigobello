package com.proyecto.ecommerceRigobello.validators;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.dto.SaleDTO;
import com.proyecto.ecommerceRigobello.dto.Sale_DetailDTO;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SaleValidations {

    public void check(SaleModel sale) {
        if(sale == null) {
            throw new IllegalArgumentException("Venta sin valores");
        }
        if(sale.getClientId() == null) {
            throw new IllegalArgumentException("Faltan completar los datos del cliente.");
        }
    }
    public void checkId(Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("ID invalido");
        }
    }
    public void checkList(List<SaleModel> sales) throws Exception {
        if(sales == null || sales.isEmpty())
            throw new ResourceNotFoundException("No hay ventas en la Base de Datos.");
    }

    public void checkDTO(SaleDTO sale) {
        if(sale == null) {
            throw new IllegalArgumentException("No hay datos para la venta.");
        }

        if(sale.getDetail() == null || sale.getDetail().size() == 0 || sale.getDetail().isEmpty() || sale.getClientId() < 0)
            throw new IllegalArgumentException("Datos incompletos o erroneos.");

        for (Sale_DetailDTO detailDto : sale.getDetail())
        {
            if(detailDto == null || detailDto.getQuantity() < 0 || detailDto.getProductId() < 0)
                throw new IllegalArgumentException("Datos erroneos");
        }
    }
}
