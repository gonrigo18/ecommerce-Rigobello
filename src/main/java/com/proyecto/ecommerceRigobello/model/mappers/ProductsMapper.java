package com.proyecto.ecommerceRigobello.model.mappers;

import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;

public class ProductsMapper {

    public static ProductsResponse skuResponse (ProductsModel products){
        return ProductsResponse.builder()
                .id(products.getId())
                .sku(products.getSku())
                .stock(products.getStock())
                .description(products.getDescription())
                .high_date(products.getHigh_date())
                .purchase_price(products.getPurchase_price())
                .sale_price(products.getSale_price())
                .build();
    }




}
