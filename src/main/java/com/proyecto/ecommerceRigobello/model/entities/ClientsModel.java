package com.proyecto.ecommerceRigobello.model.entities;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


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


}
