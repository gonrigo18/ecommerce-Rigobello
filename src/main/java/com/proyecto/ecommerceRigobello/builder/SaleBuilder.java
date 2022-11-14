package com.proyecto.ecommerceRigobello.builder;

import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class SaleBuilder {



    public static SaleResponse entityToResponse(SaleModel p) {
        return SaleResponse.builder()
                .id_sale(p.getId_sale())
                .issue_date(p.getIssue_date())
                .client(p.getClient())
                .total(p.getTotal())
                .build();
    }

    public static List<SaleResponse> entityToResponseList(List<SaleModel> entityList) {
        return entityList.stream()
                .map(SaleBuilder::entityToResponse)
                .collect(Collectors.toList());
    }

}
