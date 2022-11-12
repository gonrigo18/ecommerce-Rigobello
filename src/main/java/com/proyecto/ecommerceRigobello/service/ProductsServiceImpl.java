package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.builder.ProductsBuilder;
import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.request.ProductsRequest;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;
import com.proyecto.ecommerceRigobello.repository.ProductsRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;
    @Override
    public ProductsResponse create(ProductsRequest product) throws ApiException {
        try{
            ProductsModel p = productsRepository.getProductByCode(product.getSku());
            if (p == null){
                ProductsModel saveProduct= ProductsBuilder.requestToEntity(product);
                ProductsModel entity = productsRepository.save(saveProduct);
                return ProductsBuilder.entityToResponse(entity);
            }
            else{
                throw new ApiException("Producto Existente");
            }
        }
        catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    @Override
    public List<ProductsResponse> findAll() {
        List<ProductsModel> productListEntity = productsRepository.findAll();
        return ProductsBuilder.entityToResponseList(productListEntity);
    }

    @Override
    public ProductsResponse findBySku(Long id)throws ApiException {
        try {
            ProductsModel p = productsRepository.getProductByCode(id);
            if (p==null){
                throw new ApiException("Elemento no encontrado");
            }
            else{
                return ProductsBuilder.entityToResponse(p);
            }
        }
        catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    public ProductsResponse findByProductAndQuantity(Long id, int quantity) throws ApiException{
        try {
            ProductsModel p = productsRepository.getProductAndQuantity(id,quantity);
            if (p==null){
                throw new ApiException("Elemento no existente o cantidad insuficiente del producto: " + id);
            }
            else{
                return ProductsBuilder.entityToResponse(p);
            }
        }
        catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }
    public ProductsResponse update(ProductsRequest product) throws ApiException {

        try {
            ProductsResponse wanted = findBySku(product.getSku());
            productsRepository.delete(ProductsBuilder.responseToEntity(wanted));
            ProductsModel updated = productsRepository.save(ProductsBuilder.requestToEntity(product));
            return ProductsBuilder.entityToResponse(updated);
        }
        catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }

    public void deleteById(Long id)throws ApiException{
        try {
            ProductsResponse delete = findBySku(id);
            productsRepository.deleteProd(delete.getSku());
        }
        catch (Exception e) {
            throw new ApiException(e.getMessage());
        }

    }

    @Override
    public void discountStock (Long id, int quantity) throws ApiException{
        try {
            ProductsResponse wanted = findByProductAndQuantity(id,quantity);
            wanted.setStock(wanted.getStock()-quantity);
            productsRepository.delete(ProductsBuilder.responseToEntity(wanted));
            productsRepository.save(ProductsBuilder.responseToEntity(wanted));
        }
        catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }


}
