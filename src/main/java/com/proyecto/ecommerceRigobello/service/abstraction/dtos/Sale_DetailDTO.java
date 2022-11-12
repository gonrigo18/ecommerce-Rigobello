package com.proyecto.ecommerceRigobello.service.abstraction.dtos;

import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import lombok.Data;


@Data
public class Sale_DetailDTO {

    private Long id;
    private String description;
    private int quantity;
    private SaleModel sale;
    private ProductsModel products;
    private Double subtotal;
}
