package com.proyecto.ecommerceRigobello.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
}
