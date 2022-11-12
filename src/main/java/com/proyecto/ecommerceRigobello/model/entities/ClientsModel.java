package com.proyecto.ecommerceRigobello.model.entities;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Builder
@Entity
@Data
@Table(name = "clients")
public class ClientsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "dni", unique = true)
    private Long dni;

    @Column (name="high_date")
    private Date high_date;
}
