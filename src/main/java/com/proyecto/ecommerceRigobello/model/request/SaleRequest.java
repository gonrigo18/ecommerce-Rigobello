package com.proyecto.ecommerceRigobello.model.request;

import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SaleRequest {

    private Long dni;
    private List<Sale_detailRequest> detail;

}
