package com.proyecto.ecommerceRigobello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class SaleDTO {

    private final long clientId;
    private final List<Sale_DetailDTO> detail;

}
