package com.proyecto.ecommerceRigobello.model.entities;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "products")
public class ProductsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;

    @Column (name ="sku")
    private Long sku;

    @Column (name ="description")
    private String description;

    @Column (name = "purchase_price")
    private BigDecimal purchase_price;

    @Column (name = "sale_price")
    private BigDecimal sale_price;

    @Column (name ="stock")
    private int stock;

}
