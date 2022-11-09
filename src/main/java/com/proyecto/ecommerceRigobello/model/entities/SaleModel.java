package com.proyecto.ecommerceRigobello.model.entities;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "sale")
public class SaleModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "high_date")
    private Date high_date;

    @Column (name = "quantity")
    private int quantity;

    @Column (name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientsModel client;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Sale_detailModel> sale_Detail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SaleModel saleModel = (SaleModel) o;
        return id != null && Objects.equals(id, saleModel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
