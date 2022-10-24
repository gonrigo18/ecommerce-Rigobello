package com.proyecto.ecommerceRigobello.model.mapper;

import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;

public class SaleMapper {

    public static SaleResponse saleResponse(SaleModel sale){
        return SaleResponse.builder()
                .id(sale.getId())
                .high_date(sale.getHigh_date())
                .total(sale.getTotal())
                .client(sale.getClient())
                .sale_detail(sale.getSale_detail())
                .build();
    }


}
