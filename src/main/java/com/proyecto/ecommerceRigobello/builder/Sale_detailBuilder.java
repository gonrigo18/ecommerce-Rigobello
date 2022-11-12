package com.proyecto.ecommerceRigobello.builder;

import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;

public class Sale_detailBuilder {

    public static Sale_detailResponse entityToResponse(Sale_detailModel p) {
        return Sale_detailResponse.builder()
                .id_detail(p.getId_detail())
                .product_detail(p.getProduct_detail())
                .quantity(p.getQuantity())
                .price(p.getPrice())
                .total(p.getTotal())
                .build();
    }
}
