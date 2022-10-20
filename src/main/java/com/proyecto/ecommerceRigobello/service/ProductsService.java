package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.model.ProductsModel;
import com.proyecto.ecommerceRigobello.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    ProductsRepository productsRepository;
    public ProductsModel create(ProductsModel newProduct) { return this.productsRepository.save(newProduct);}

    public List<ProductsModel> findAll() {return this.productsRepository.findAll();}

    public ProductsModel update(ProductsModel product, Long id){
        Optional<ProductsModel> productBD= this.productsRepository.findById(id);
        if (productBD.isPresent()){
            ProductsModel a = productBD.get();
            a.setDescription(product.getDescription());
            a.setSku(product.getSku());
            a.setStock(product.getStock());
            a.setHigh_date(product.getHigh_date());
            a.setPurchase_price(product.getPurchase_price());
            a.setSale_price(product.getSale_price());
            return this.productsRepository.save(a);
        }else{
            return null;
        }
    }
}

