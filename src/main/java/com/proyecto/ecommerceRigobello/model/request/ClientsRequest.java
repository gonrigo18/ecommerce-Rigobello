package com.proyecto.ecommerceRigobello.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientsRequest {
    private Long id_client;
    private String name;
    private String lastname;
    private Long dni;
    private Date high_date;
}
