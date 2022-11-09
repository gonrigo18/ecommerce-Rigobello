package com.proyecto.ecommerceRigobello.externRepo;

import com.proyecto.ecommerceRigobello.model.entities.WorldClock;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ClockWorldRest {
    public Date getDate() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        try{
            WorldClock worldClock = restTemplate.getForObject("http://worldclockapi.com/api/json/utc/now", WorldClock.class);
            String currentDateTime = worldClock.getCurrentDateTime();
            Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'").parse(currentDateTime);
            return date;
        } catch(Exception e){
            return new Date();
        }
    }
}
