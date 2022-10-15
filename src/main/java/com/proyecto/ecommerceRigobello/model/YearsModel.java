package com.proyecto.ecommerceRigobello.model;

import lombok.Data;
import javax.persistence.*;

@Data
public class YearsModel {

    private String name;

    private String lastname;
    private Long years;

    public void saveName (String name){
        this.name = name;
    }
    public void saveLastName (String lastname){
        this.lastname = lastname;
    }
    public void saveYears(Long age) {
        this.years = age;
    }

}
