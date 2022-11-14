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

    @Column (name="issue_date")
    private Date issue_date;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientsModel client;

    @ManyToMany
    @JoinColumn(name = "id_detail", columnDefinition = "text[]" )
    private List<Sale_detailModel> detail;
    private BigDecimal total;

}
