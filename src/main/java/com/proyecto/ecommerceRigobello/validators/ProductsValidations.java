package com.proyecto.ecommerceRigobello.validators;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Component
public class ProductsValidations {
    public void check(ProductsModel product){
        if(product == null) {
            throw new IllegalArgumentException("No ingresó valores.");
        }
        if(product.getSku().isBlank() || product.getDescription().isBlank() || product.getStock() == null || product.getBuy_price() == null || product.getSale_price() == null || product.getHigh_Date().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("No puede ingresar datos vacios");
        }
    }
    public void checkId(Long id) {
        if(id == null || id < 0) {
            throw new IllegalArgumentException("Id invalido.");
        }
    }
    public void checkSku(ProductsModel product) {
        if(product == null) {
            throw new IllegalArgumentException("No existe un producto con ese SKU.");
        }
    }
    public void checkList(List<ProductsModel> products) throws Exception {
        if(products == null || products.isEmpty())
            throw new ResourceNotFoundException("No hay productos en la Base.");
    }
}
