package com.proyecto.ecommerceRigobello.model.entities;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "sale")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sale;

    @Column
    private Date issue_date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientsModel client;

    @ManyToMany
    @JoinColumn(name = "detail_id", columnDefinition = "text[]" )
    private List<Sale_detailModel> sale_detail;

    @Column (name = "total")
    private BigDecimal total;

}
