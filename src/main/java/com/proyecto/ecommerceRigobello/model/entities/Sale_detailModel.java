package com.proyecto.ecommerceRigobello.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sale_detail")
public class Sale_detailModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @ManyToOne
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



