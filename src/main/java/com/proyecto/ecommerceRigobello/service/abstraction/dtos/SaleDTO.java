package com.proyecto.ecommerceRigobello.service.abstraction.dtos;

import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
public class SaleDTO  {

    private Long id;
    private LocalDate high_date;
    private Integer quantity;
    private Double total;
    private ClientsModel client;
    private Set<Sale_DetailDTO> line;
}
