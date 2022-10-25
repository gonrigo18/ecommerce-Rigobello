package com.proyecto.ecommerceRigobello.model.mappers;

import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;

public class Sale_detailMapper {

    public static Sale_detailResponse detailResponse (Sale_detailModel detail){

        return Sale_detailResponse.builder()
                .id(detail.getId())
                .sale(detail.getSale())
                .products(detail.getProducts())
                .quantity(detail.getQuantity())
                .subtotal(detail.getSubtotal())
                .build();

    }
}
