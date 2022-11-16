package com.proyecto.ecommerceRigobello.repository;

import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface Sale_detailRepository extends JpaRepository <Sale_detailModel, Long> {

    @Query(value = "select * from sale_detail where id_sale = ?1", nativeQuery = true)
    public List<Sale_detailModel> getSale_detail(long id);

    @Query(value = "Select * from sale_detail where id_product = ?1", nativeQuery = true)
    public List<Sale_detailModel> findByProductId(long id);

}
