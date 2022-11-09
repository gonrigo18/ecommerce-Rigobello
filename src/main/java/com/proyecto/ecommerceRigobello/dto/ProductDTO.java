package com.proyecto.ecommerceRigobello.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductDTO {

    private String sku;
    private String description;
    private Double purchase_price;
    private Double sale_price;
    private int stock;
    private LocalDate high_date;
    private Long id;

    public ProductDTO(String description, int quantity, Double subtotal, Long id) {
    }

    public ProductDTO() {

    }
}
