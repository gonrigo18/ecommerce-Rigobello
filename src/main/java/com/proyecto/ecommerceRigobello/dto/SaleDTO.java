package com.proyecto.ecommerceRigobello.dto;

import lombok.Data;
import java.util.List;

@Data
public class SaleDTO {

    private final long clientId;
    private final List<Sale_DetailDTO> detail;

}
