package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import java.util.List;
import java.util.Optional;

public interface ProductsService {

    public Optional<ProductsModel> findById(Long id) throws Exception;
    public ProductsModel findBySku(String sku)throws Exception;
    public List<ProductsModel> findAll() throws Exception;
    public String create(ProductsModel newProduct) throws Exception;
    public String update(ProductsModel product, Long id) throws Exception;
    public String updateStock(Long id, int stock, String cont) throws Exception;
    public String deleteById(Long id) throws Exception;
}
