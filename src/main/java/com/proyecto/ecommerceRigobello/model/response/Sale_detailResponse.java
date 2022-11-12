package com.proyecto.ecommerceRigobello.model.response;

import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sale_detailResponse {

        private Long id_detail;
        private ProductsModel product_detail;
        private int quantity;
        private BigDecimal price;
        private BigDecimal total;
}
