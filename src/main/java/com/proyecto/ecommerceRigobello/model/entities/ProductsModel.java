package com.proyecto.ecommerceRigobello.model.entities;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class ProductsModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name ="sku")
    private String sku;

    @Column (name ="description")
    private String description;

    @Column (name = "purchase_price")
    private Double purchase_price;

    @Column (name = "sale_price")
    private Double sale_price;

    @Column (name ="stock")
    private int stock;

    @Column (name = "high_date")
    private String high_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductsModel that = (ProductsModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
