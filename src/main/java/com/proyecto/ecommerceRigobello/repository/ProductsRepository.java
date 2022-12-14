package com.proyecto.ecommerceRigobello.repository;

import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepository extends JpaRepository <ProductsModel,Long> {

    @Query(value = "select * from products where sku = ?1 and stock > 0", nativeQuery = true)
    public ProductsModel findBySku(String sku);
}
