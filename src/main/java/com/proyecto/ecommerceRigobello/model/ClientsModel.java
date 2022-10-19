package com.proyecto.ecommerceRigobello.model;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "clients")
public class ClientsModel {

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

    @OneToMany (mappedBy = "client", cascade = CascadeType.ALL)
    private List<SaleModel> sale;

}
