package com.proyecto.ecommerceRigobello.model.response;

import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleResponse {

    private Long id;
    private LocalDate high_date;
    private Double total;
    private ClientsModel client;

}
