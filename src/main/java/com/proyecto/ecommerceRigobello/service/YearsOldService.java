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

    public Optional<YearsModel> calculateYears(Long id){
        Optional<ClientModel> clientBD= this.yearsOldRepository.findById(id);
        if(clientBD.isPresent()){
            ClientModel client = clientBD.get();
            YearsModel client2 = new YearsModel();
            var name = client.getName();
            var lastname = client.getLastname();
            var born = client.getBirth_date();
            LocalDate now = LocalDate.now();
            long age= ChronoUnit.YEARS.between(born, now);
            client2.saveName(name);
            client2.saveLastName(lastname);
            client2.saveYears(age);
            return Optional.of(client2);
        }else{
            return null;
        }
    }

}
