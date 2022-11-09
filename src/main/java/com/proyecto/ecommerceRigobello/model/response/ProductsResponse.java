package com.proyecto.ecommerceRigobello.model.response;

import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductsResponse extends ProductsModel {

    private Long id;
    private String sku;
    private String description;
    private Double purchase_price;
    private Double sale_price;
    private int stock;
    private String high_date;
}
