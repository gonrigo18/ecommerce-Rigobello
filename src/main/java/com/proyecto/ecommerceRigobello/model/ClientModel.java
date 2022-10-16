package com.proyecto.ecommerceRigobello.model;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;



@Data
@Entity
@Table(name = "client")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")

    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column (name ="birth_date")
    private LocalDate birth_date;

}