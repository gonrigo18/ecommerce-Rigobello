package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceAlreadyExistsException;
import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.repository.ProductsRepository;
import com.proyecto.ecommerceRigobello.repository.Sale_detailRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.ProductsService;
import com.proyecto.ecommerceRigobello.validators.ProductsValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductsValidations productsValidations;
    @Autowired
    private Sale_detailRepository sale_detailRepository;

    @Override
    public Optional<ProductsModel> findById(Long id) throws ResourceNotFoundException {
        this.productsValidations.checkId(id);
        Optional<ProductsModel> product = this.productsRepository.findById(id);;
        if(product.isPresent()) {
            return product;
        }else {
            throw new ResourceNotFoundException("No existe el producto");
        }
    }
    @Override
    public ProductsModel findBySku(String sku) {
        ProductsModel product = this.productsRepository.findBySku(sku);
        this.productsValidations.checkSku(product);
        return product;
    }
    @Override
    public List<ProductsModel> findAll() throws ResourceNotFoundException {
        List<ProductsModel> products = this.productsRepository.findAll();
        this.productsValidations.checkList(products);
        return this.productsRepository.findAll();
    }
    @Override
    public String create(ProductsModel newProduct) throws ResourceNotFoundException {
        productsValidations.check(newProduct);
        Optional<ProductsModel> productDB = Optional.ofNullable(this.productsRepository.findBySku(newProduct.getSku()));
        if(productDB.isPresent()) {
            newProduct.setStock(newProduct.getStock() + productDB.get().getStock());
            newProduct.setHigh_date(LocalDate.now());
            ProductsModel prod = productDB.get();
            prod.setStock(0);
            update(prod, prod.getId());
        }
        productsRepository.save(newProduct);
        return newProduct.NewProduct();
    }
    @Override
    public String update(ProductsModel product, Long id) throws ResourceNotFoundException {
        productsValidations.check(product);
        Optional<ProductsModel> productDB = this.productsRepository.findById(id);
        if(productDB.isPresent()) {
            ProductsModel prod = productDB.get();
            prod.setSku(product.getSku());
            prod.setDescription(product.getDescription());
            prod.setStock(product.getStock());
            prod.setBuy_price(product.getBuy_price());
            prod.setSale_price(product.getSale_price());
            prod.setHigh_date(product.getHigh_date());
            this.productsRepository.save(prod);
            return prod.updatedProduct();
        }
        else {
            throw new ResourceNotFoundException("El producto que desea actualizar no se encuentra");
        }
    }

    @Override
    public String updateStock(Long id, int stock, String cont) throws ResourceNotFoundException {
        Optional<ProductsModel> product = this.productsRepository.findById(id);
        if(product.isEmpty()) {
            throw new ResourceNotFoundException("No se encontró el producto");
        }
        if(stock <= 0) {
            throw new IllegalArgumentException("Valor invalido, debe ser mayor a 0");
        }
        if(cont.equals("+")) {
            product.get().setStock((product.get().getStock() + stock));
        }
        else if(cont.equals("-")) {
            if(product.get().getStock() - stock < 0) {
                throw new IllegalArgumentException("Stock insuficiente" + product.get().getId() +". Stock actual: " + product.get().getStock());
            }
            else {
                product.get().setStock(product.get().getStock() - stock);
            }
        }
        else {
            throw new IllegalArgumentException("Debe ingresar: \"+\" o \"-\".");
        }
        this.productsRepository.save(product.get());
        return product.get().updatedProduct();
    }

    @Override
    public String deleteById(Long id) throws ResourceNotFoundException,ResourceAlreadyExistsException {
        if(id == null) {
            throw new IllegalArgumentException("ID no ingresado");
        }
        Optional<ProductsModel> product = this.productsRepository.findById(id);
        if(product.isEmpty()) {
            throw new ResourceNotFoundException("No se encontró el producto.");
        }
        List<Sale_detailModel> byProductId = sale_detailRepository.findByProductId(id);
        if(byProductId.size() != 0) {
            throw new ResourceAlreadyExistsException("El producto no puede eliminarse");
        }
        this.productsRepository.deleteById(id);
        return "ok";
    }

}
