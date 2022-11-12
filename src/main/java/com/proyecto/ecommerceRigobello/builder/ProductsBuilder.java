package com.proyecto.ecommerceRigobello.builder;

import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.request.ProductsRequest;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsBuilder {

    public static ProductsResponse entityToResponse(ProductsModel p) {
        return ProductsResponse.builder()
                .id_product(p.getId_product())
                .sku(p.getSku())
                .description(p.getDescription())
                .purchase_price(p.getPurchase_price())
                .sale_price(p.getSale_price())
                .stock(p.getStock())
                .build();
    }

    public static List<ProductsResponse> entityToResponseList(List<ProductsModel> entityList) {
        return entityList.stream().map(ProductsBuilder::entityToResponse).collect(Collectors.toList());
    }

    public static ProductsModel requestToEntity(ProductsRequest p) {
        return ProductsModel.builder()
                .sku (p.getSku())
                .description(p.getDescription())
                .purchase_price(p.getPurchase_price())
                .sale_price(p.getSale_price())
                .stock(p.getStock())
                .build();
    }


    public static ProductsModel responseToEntity (ProductsResponse p) {
        return ProductsModel.builder()
                .sku(p.getSku())
                .description(p.getDescription())
                .purchase_price(p.getPurchase_price())
                .sale_price(p.getSale_price())
                .stock(p.getStock())
                .build();
    }


}
