package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.builder.ClientsBuilder;
import com.proyecto.ecommerceRigobello.builder.ProductsBuilder;
import com.proyecto.ecommerceRigobello.builder.Sale_detailBuilder;
import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.model.request.Sale_detailRequest;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;
import com.proyecto.ecommerceRigobello.repository.Sale_detailRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.ProductsService;
import com.proyecto.ecommerceRigobello.service.abstraction.Sale_detailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class Sale_detailServiceImpl implements Sale_detailService{

   private final Sale_detailRepository sale_detailRepository;
   private final ProductsService productsService;

    @Override
    public List<Sale_detailResponse> findAll(){
        List<Sale_detailModel> clientsListEntities = sale_detailRepository.findAll();
        return Sale_detailBuilder.entityToResponseList(clientsListEntities);
    }
     public Sale_detailResponse addToCart(Sale_detailRequest dp) throws ApiException {
        try {
            ProductsResponse p = productsService.findByProductAndQuantity(dp.getProductDetail(), dp.getQuantity());
            productsService.discountStock(dp.getProductDetail(), dp.getQuantity());
            Sale_detailModel dpEntity = new Sale_detailModel();
            dpEntity.setQuantity(dp.getQuantity());
            dpEntity.setPrice(p.getSale_price());
            dpEntity.setPrice(p.getSale_price().multiply(BigDecimal.valueOf(dp.getQuantity())));
            dpEntity.setProductDetail(ProductsBuilder.responseToEntity(p));
            sale_detailRepository.save(dpEntity);
            return Sale_detailBuilder.entityToResponse(dpEntity);
        }
        catch (Exception e){
            throw new ApiException(e.getMessage());
        }

    }

}