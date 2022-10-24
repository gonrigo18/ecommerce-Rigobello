package com.proyecto.ecommerceRigobello.model.response;

import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientsResponse {
    private Long id;
    private String name;
    private String lastname;
    private String dni;
    private LocalDate birth_date;
    private List<SaleModel> sale;;
    private Integer years;
}
