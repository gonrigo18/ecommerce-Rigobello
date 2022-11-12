package com.proyecto.ecommerceRigobello.model.response;

import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponse {

    private Long id_product;
    private Long sku;
    private String description;
    private BigDecimal purchase_price;
    private BigDecimal sale_price;
    private int stock;
}
