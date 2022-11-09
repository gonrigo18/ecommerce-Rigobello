package com.proyecto.ecommerceRigobello.model.entities;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "sale_detail")
public class Sale_detailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private SaleModel sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductsModel products;

    @Column(name = "subtotal")
    private Double subtotal;

    public Sale_detailModel() {
    }

    public Sale_detailModel(String description, Double sale_price, int quantity, Long productId, SaleModel saleId) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSaleId() {
        return sale.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Sale_detailModel that = (Sale_detailModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}



