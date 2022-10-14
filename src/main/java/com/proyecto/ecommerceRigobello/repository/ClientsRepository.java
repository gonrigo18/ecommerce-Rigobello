package com.proyecto.ecommerceRigobello.repository;


import com.proyecto.ecommerceRigobello.model.ClientsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientsRepository extends JpaRepository <ClientsModel, Long> {
}
