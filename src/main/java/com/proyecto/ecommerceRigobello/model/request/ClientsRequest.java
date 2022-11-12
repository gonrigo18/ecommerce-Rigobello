package com.proyecto.ecommerceRigobello.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientsRequest {
    private String name;
    private String lastname;
    private Long dni;
}
