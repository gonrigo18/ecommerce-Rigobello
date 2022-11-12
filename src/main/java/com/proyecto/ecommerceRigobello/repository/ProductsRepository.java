package com.proyecto.ecommerceRigobello.repository;

import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductsRepository extends JpaRepository <ProductsModel,Long> {

    @Query("Select p FROM ProductsModel p WHERE p.sku =:sku")
    public  ProductsModel getProductByCode(@Param("sku")Long sku);


    @Query("Select p FROM ProductsModel p WHERE p.sku =:sku AND p.stock >:quantity")
    public  ProductsModel getProductAndQuantity(@Param("sku")Long sku, @Param("quantity")int quantity);

    @Transactional
    @Modifying
    @Query("delete FROM ProductsModel p WHERE p.sku =:sku")
    public  void deleteProd(@Param("sku")long quantity);
}
