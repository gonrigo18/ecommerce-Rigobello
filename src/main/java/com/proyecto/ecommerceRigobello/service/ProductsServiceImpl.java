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
        return ProductsMapper.skuResponse(productsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El producto no existe")));
    }
    public ProductsModel update(ProductsModel product, Long id) throws Exception {
        ProductsModel productBD = this.productsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El producto no existe"));
            productBD.setSku(product.getSku());
            productBD.setStock(product.getStock());
            productBD.setDescription(product.getDescription());
            productBD.setSale_price(product.getSale_price());
            productBD.setPurchase_price(product.getPurchase_price());
            return this.productsRepository.save(productBD);
    }
    public void delete (Long id){
        this.productsRepository.deleteById(id);
    }


}
