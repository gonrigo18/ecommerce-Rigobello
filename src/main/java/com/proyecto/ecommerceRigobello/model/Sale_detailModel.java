package com.proyecto.ecommerceRigobello.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sale_detail")
public class Sale_detailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @ManyToOne
   @JoinColumn (name = "sale_id")
    private SaleModel sale;

    @Column (name = "detail_id")
    private Long detail_id;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private ProductsModel products;

    @Column (name = "quantity")
    private int quantity;

    @Column (name = "subtotal")
    private Double subtotal;

}



