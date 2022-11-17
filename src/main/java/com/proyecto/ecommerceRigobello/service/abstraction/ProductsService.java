package com.proyecto.ecommerceRigobello.service.abstraction;


import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceAlreadyExistsException;
import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import java.util.List;
import java.util.Optional;

public interface ProductsService {

    public Optional<ProductsModel> findById(Long id) throws ResourceNotFoundException;
    public ProductsModel findBySku(String sku);
    public List<ProductsModel> findAll() throws ResourceNotFoundException;
    public String create(ProductsModel newProduct) throws ResourceNotFoundException, ResourceAlreadyExistsException;
    public String update(ProductsModel product, Long id) throws ResourceNotFoundException;
    public String updateStock(Long id, int stock, String cont) throws ResourceNotFoundException;
    public String deleteById(Long id) throws ResourceNotFoundException, ResourceAlreadyExistsException;
}
