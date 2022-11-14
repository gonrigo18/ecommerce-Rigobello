package com.proyecto.ecommerceRigobello.builder;

import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;

import java.util.List;
import java.util.stream.Collectors;

public class Sale_detailBuilder {

    public static Sale_detailResponse entityToResponse(Sale_detailModel p) {
        return Sale_detailResponse.builder()
                .id_detail(p.getId_detail())
                .productDetail(p.getProductDetail())
                .quantity(p.getQuantity())
                .price(p.getPrice())
                .total(p.getTotal())
                .build();
    }

    public static List<Sale_detailResponse> entityToResponseList(List<Sale_detailModel> entityList) {
        return entityList.stream()
                .map(Sale_detailBuilder::entityToResponse)
                .collect(Collectors.toList());
    }
}
