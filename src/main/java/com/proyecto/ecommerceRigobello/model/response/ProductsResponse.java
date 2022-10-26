package com.proyecto.ecommerceRigobello.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductsResponse {

    private Long id;
    private String sku;
    private String description;
    private Double purchase_price;
    private Double sale_price;
    private int stock;
    private String high_date;
}
