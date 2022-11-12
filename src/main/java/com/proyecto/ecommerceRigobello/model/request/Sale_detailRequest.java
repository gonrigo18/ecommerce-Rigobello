package com.proyecto.ecommerceRigobello.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale_detailRequest {
    private Long productDetail;
    private int quantity;
}
