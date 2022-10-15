package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.model.ClientModel;
import com.proyecto.ecommerceRigobello.model.YearsModel;
import com.proyecto.ecommerceRigobello.repository.YearsOldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class YearsOldService {

    @Autowired
    YearsOldRepository yearsOldRepository;


    public List<ClientModel> findAll(){ return this.yearsOldRepository.findAll();}

    /*public Optional<ClientModel> findById(Long id){
        Optional<ClientModel> clientBD= this.yearsOldRepository.findById(id);
        if(clientBD.isPresent()){
            ClientModel client = clientBD.get();
            client.setName(client.getName());
            client.setLastname(client.getLastname());
            client.setBirth_date(client.getBirth_date());
            var name = client.getName();
            var lastname = client.getLastname();
            var burn = client.getBirth_date();
            LocalDate now = LocalDate.now();
            long edad= ChronoUnit.YEARS.between(burn, now);
            System.out.println("name: " + name);
            System.out.println("Lastname: " + lastname);
            System.out.println("Edad: " + edad);
            client.saveYears(edad);
            return Optional.of(client);
        }else{
            return null;
        }
    }*/

    public Optional<YearsModel> findById(Long id){
        Optional<ClientModel> clientBD= this.yearsOldRepository.findById(id);
        if(clientBD.isPresent()){
            ClientModel client = clientBD.get();
            YearsModel client2 = new YearsModel();
            var name = client.getName();
            var lastname = client.getLastname();
            var burn = client.getBirth_date();
            LocalDate now = LocalDate.now();
            long edad= ChronoUnit.YEARS.between(burn, now);
            client2.saveName(name);
            client2.saveLastName(lastname);
            client2.saveYears(edad);
            return Optional.of(client2);
        }else{
            return null;
        }
    }

}
