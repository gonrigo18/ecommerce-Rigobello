package com.proyecto.ecommerceRigobello.repository;

import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SaleRepository extends JpaRepository <SaleModel,Long> {

    @Query(value = "Select * from sale where id_client = ?1", nativeQuery = true)
    public List<SaleModel> findByClientId(Long id);
}
