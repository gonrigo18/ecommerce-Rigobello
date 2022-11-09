package com.proyecto.ecommerceRigobello.saleJson;

import lombok.Data;
import java.util.List;

@Data
public class SaleJson {
    private Long clientID;
    private List<ProductJson> products;
}
