package com.proyecto.ecommerceRigobello.service;


import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.ClientsModel;
import com.proyecto.ecommerceRigobello.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

   @Autowired
   ClientsRepository clientsRepository;

   public ClientsModel create(ClientsModel newClient){
       return this.clientsRepository.save(newClient);
   }

   public List<ClientsModel> findAll(){
    return this.clientsRepository.findAll();
   }

    public Optional<ClientsModel> findById(Long id) throws ResourceNotFoundException {
        Optional<ClientsModel> clientBD= this.clientsRepository.findById(id);
        if(clientBD.isPresent()){
            ClientsModel client = clientBD.get();
            client.setName(client.getName());
            client.setLastname(client.getLastname());
            client.setBirth_date(client.getBirth_date());
            return this.clientsRepository.findById(id);
        }else{
            throw new ResourceNotFoundException("El cliente no existe");
        }
    }
   public ClientsModel update(ClientsModel client, Long id) throws ResourceNotFoundException {
       Optional<ClientsModel> clientBD= this.clientsRepository.findById(id);
       if (clientBD.isPresent()){
           ClientsModel c = clientBD.get();
           c.setLastname(client.getLastname());
           c.setName(client.getName());
           c.setBirth_date(client.getBirth_date());
           return this.clientsRepository.save(c);
       }else{
           throw new ResourceNotFoundException("El cliente no existe");
       }
   }

   public void delete (Long id){
       this.clientsRepository.deleteById(id);
   }


}
