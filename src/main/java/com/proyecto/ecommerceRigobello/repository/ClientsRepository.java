package com.proyecto.ecommerceRigobello.repository;


import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientsRepository extends JpaRepository <ClientsModel, Long> {
    ClientsModel getById(Long id);
    ClientsModel findByDni(Long dni);
}
