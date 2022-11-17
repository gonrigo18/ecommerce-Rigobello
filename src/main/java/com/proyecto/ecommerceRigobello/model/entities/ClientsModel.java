package com.proyecto.ecommerceRigobello.model.entities;


import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "clients")
public class ClientsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String dni;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column
    private LocalDate birth_date;

    public String NewClient() {
        return String.format("Cliente creado:%nID: %d | DNI: %s | Nombre y apellido: %s %s | Fecha Nacimiento: %s.%n",
                this.id, this.dni, this.name, this.lastname, this.birth_date);
    }

    public String UpdatedClient() {
        return String.format("Cliente actualizado:%nID: %d | DNI: %s | Nombre y apellido: %s %s | Fecha Nacimiento: %s.%n",
                this.id, this.dni, this.name, this.lastname, this.birth_date);
    }



}
