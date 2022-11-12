package com.proyecto.ecommerceRigobello.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "sale_detail")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sale_detailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detail;

    @ManyToOne
    @JoinColumn(name = "sku")
    private ProductsModel product_detail;

    @Column(name = "quantity")
    private int quantity;

    @Column
    private BigDecimal price;

    @Column(name = "subtotal")
    private BigDecimal total;

}



