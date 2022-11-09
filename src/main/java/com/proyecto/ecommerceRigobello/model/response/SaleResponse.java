package com.proyecto.ecommerceRigobello.model.response;

import com.proyecto.ecommerceRigobello.dto.SaleDTO;
import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleResponse extends SaleDTO {

    private Long id;
    private Date high_date;
    private Double total;
    private ClientsModel client;

}
