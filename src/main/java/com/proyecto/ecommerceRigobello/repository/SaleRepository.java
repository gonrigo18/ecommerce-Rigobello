package com.proyecto.ecommerceRigobello.repository;

import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository <SaleModel,Long> {
}
