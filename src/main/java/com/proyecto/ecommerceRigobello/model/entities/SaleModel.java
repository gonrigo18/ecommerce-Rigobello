package com.proyecto.ecommerceRigobello.model.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "sale")
@NoArgsConstructor
public class SaleModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDate high_date;

    @Column double total;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientsModel clientId;

    public SaleModel(LocalDate high_date, double total, ClientsModel clientId) {
        this.high_date = high_date;
        this.total = total;
        this.clientId = clientId;
    }

}
