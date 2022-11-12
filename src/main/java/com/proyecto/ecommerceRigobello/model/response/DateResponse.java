package com.proyecto.ecommerceRigobello.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class DateResponse {
    private Date currentDateTime;
}
