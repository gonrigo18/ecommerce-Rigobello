package com.proyecto.ecommerceRigobello.model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "sale")
public class SaleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "high_date")
    private String high_date;

    @Column (name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

    @OneToMany (mappedBy = "sale", cascade = CascadeType.ALL)
    private List<Sale_detailModel> sale_detail;

}
