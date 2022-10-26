package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.mappers.ProductsMapper;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;
import com.proyecto.ecommerceRigobello.repository.ProductsRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;
    public ProductsModel create(ProductsModel newProduct) { return this.productsRepository.save(newProduct);}

    public List<ProductsModel> findAll() {return this.productsRepository.findAll();}

    @Override
    public ProductsResponse findBySku(String sku) throws Exception{
        ProductsModel productBD = this.productsRepository.findBySku(sku);
        if (productBD != null){
            return ProductsMapper.skuResponse(productsRepository.findBySku(sku));
        }else{
            throw new ResourceNotFoundException("El producto no existe");
        }
    }

    @Override
    public ProductsResponse findById(Long id) throws Exception{
        Optional<ProductsModel> productBD = this.productsRepository.findById(id);
        if (productBD.isPresent()){
            return ProductsMapper.skuResponse(productsRepository.findById(id).orElseThrow());
        }else{
            throw new ResourceNotFoundException("El producto no existe");
        }
    }

    public ProductsModel update(ProductsModel product, Long id) throws ResourceNotFoundException {
        Optional<ProductsModel> clientBD= this.productsRepository.findById(id);
        if (clientBD.isPresent()){
            ProductsModel c = clientBD.get();
            c.setSku(product.getSku());
            c.setStock(product.getStock());
            c.setDescription(product.getDescription());
            c.setSale_price(product.getSale_price());
            c.setPurchase_price(product.getPurchase_price());
            return this.productsRepository.save(c);
        }else{
            throw new ResourceNotFoundException("El cliente no existe");
        }
    }
    public void delete (Long id){
        this.productsRepository.deleteById(id);
    }


}
