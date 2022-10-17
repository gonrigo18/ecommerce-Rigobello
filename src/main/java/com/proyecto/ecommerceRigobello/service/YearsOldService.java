package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.ClientModel;
import com.proyecto.ecommerceRigobello.dto.ClientDto;
import com.proyecto.ecommerceRigobello.repository.ClientDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class YearsOldService {

    @Autowired
    ClientDtoRepository yearsOldRepository;


    public List<ClientModel> findAll(){ return this.yearsOldRepository.findAll();}

    public Optional<ClientDto> calculateYears(Long id) throws ResourceNotFoundException {
        Optional<ClientModel> clientBD= this.yearsOldRepository.findById(id);
        if(clientBD.isPresent()){
            ClientModel client = clientBD.get();
            ClientDto client2 = new ClientDto();
            String name = client.getName();
            String lastname = client.getLastname();
            LocalDate born = client.getBirth_date();
            LocalDate now = LocalDate.now();
            long age= ChronoUnit.YEARS.between(born, now);
            client2.saveName(name);
            client2.saveLastName(lastname);
            client2.saveYears(age);
            return Optional.of(client2);
        }else{
            throw new ResourceNotFoundException("El cliente no existe");
        }
    }

}
