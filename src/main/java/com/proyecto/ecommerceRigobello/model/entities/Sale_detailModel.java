package com.proyecto.ecommerceRigobello.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sale_detail")
public class Sale_detailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @OneToOne (cascade = CascadeType.ALL)
   @JoinColumn (name = "sale_id")
    private SaleModel sale;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private ProductsModel products;

    @Column (name = "quantity")
    private int quantity;

    @Column (name = "subtotal")
    private Double subtotal;

}



