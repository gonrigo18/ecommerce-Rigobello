package com.proyecto.ecommerceRigobello.repository;


import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClientsRepository extends JpaRepository <ClientsModel, Long> {
    @Query(value = "Select * from clients where dni = ?1", nativeQuery = true)

    public ClientsModel findByDni(String dni);
}
