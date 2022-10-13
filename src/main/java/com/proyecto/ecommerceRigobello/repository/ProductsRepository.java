package com.proyecto.ecommerceRigobello.repository;

import com.proyecto.ecommerceRigobello.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository <ProductsModel,Long> {
}
