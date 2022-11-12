package com.proyecto.ecommerceRigobello.model.response;

import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleResponse {

    private Long id_sale;
    private Date issue_date;
    private ClientsModel client;
    private List<Sale_detailResponse> detail;
    private BigDecimal total;

}
