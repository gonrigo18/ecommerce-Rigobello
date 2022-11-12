package com.proyecto.ecommerceRigobello.externRepo;

import com.proyecto.ecommerceRigobello.model.response.DateResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DateApi {
    public DateResponse getDate(){
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://worldclockapi.com/api/json/utc/now";
        return restTemplate.getForObject(url, DateResponse.class,"currentDateTime");

    }
}
