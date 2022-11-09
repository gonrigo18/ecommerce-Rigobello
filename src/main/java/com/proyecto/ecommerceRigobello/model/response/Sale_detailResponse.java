package com.proyecto.ecommerceRigobello.model.response;

import com.proyecto.ecommerceRigobello.model.entities.ProductsModel;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.model.entities.Sale_detailModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@Builder
public class Sale_detailResponse extends Sale_detailModel {

        private Long id;
        private String description;
        private int quantity;
        private SaleModel sale;
        private ProductsModel products;
        private Double subtotal;
}
