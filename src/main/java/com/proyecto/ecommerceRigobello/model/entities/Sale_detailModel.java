package com.proyecto.ecommerceRigobello.model.entities;


import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Table(name = "sale_detail")
@NoArgsConstructor
public class Sale_detailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_sale")
    private SaleModel saleId;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private ProductsModel productId;

    @Column
    private int quantity;

    @Column
    private double total;

    public Sale_detailModel(long id, ProductsModel productId, int quantity, double total) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.total = total;
    }
}



