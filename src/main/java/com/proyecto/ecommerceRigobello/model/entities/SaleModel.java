package com.proyecto.ecommerceRigobello.model.entities;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "sale")
public class SaleModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "high_date")
    private LocalDate high_date;

    @Column (name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientsModel client;

    @OneToOne(mappedBy = "sale", cascade = CascadeType.ALL)
    private Sale_detailModel sale_detail;

}
