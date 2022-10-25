package com.proyecto.ecommerceRigobello.model.entities;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "clients")
public class ClientsModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "dni", unique = true)
    private String dni;

    @Column (name ="birth_date")
    private LocalDate birth_date;

    @OneToMany (mappedBy = "client")
    private List<SaleModel> sales;


}
