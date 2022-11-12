package com.proyecto.ecommerceRigobello.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsRequest {


    private Long sku;
    private String description;
    private BigDecimal sale_price;
    private BigDecimal purchase_price;
    private int stock;
}
