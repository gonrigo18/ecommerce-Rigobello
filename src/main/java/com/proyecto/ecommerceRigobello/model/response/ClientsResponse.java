package com.proyecto.ecommerceRigobello.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientsResponse {
    private String name;
    private String lastname;
    private Long dni;
    private Date high_Date;
}
