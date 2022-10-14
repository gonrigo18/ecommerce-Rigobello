package com.proyecto.ecommerceRigobello.repository;


import com.proyecto.ecommerceRigobello.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YearsOldRepository extends JpaRepository <ClientModel, Long>{

}
