package com.proyecto.ecommerceRigobello.model.entities;


import lombok.*;
import javax.persistence.*;
import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "clients")
public class ClientsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;

    @Column(name = "dni")
    private Long dni;

    @Column (name= "name")
    private String name;

    @Column (name = "lastname")
    private String lastname;

    @Column (name= "high_date")
    private Date high_date;
}
