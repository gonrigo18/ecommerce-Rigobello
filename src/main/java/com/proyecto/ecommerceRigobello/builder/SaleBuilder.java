package com.proyecto.ecommerceRigobello.builder;

import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.model.request.SaleRequest;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SaleBuilder {

    public static SaleModel requestToEntity(SaleRequest c) {
        return SaleModel.builder()
                .client (null)
                .build();
    }

    public static SaleResponse entityToResponse(SaleModel p) {
        return SaleResponse.builder()
                .id_sale(p.getId_sale())
                .issue_date(p.getIssue_date())
                .client(p.getClient())
                .total(p.getTotal())
                .build();
    }

    public static List<ProductsResponse> entityToResponseList(List<ProductsModel> entityList) {
        return entityList.stream().map(ProductsBuilder::entityToResponse).collect(Collectors.toList());
    }
}
