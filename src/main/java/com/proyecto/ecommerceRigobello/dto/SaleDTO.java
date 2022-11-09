package com.proyecto.ecommerceRigobello.dto;


import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class SaleDTO {
    Long id;
    private Date date;
    private List<ProductDTO> description;
    private Double total;
    private int quantity;
    private Long clientID;
}
