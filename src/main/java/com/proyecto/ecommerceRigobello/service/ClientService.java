package com.proyecto.ecommerceRigobello.service;


import com.proyecto.ecommerceRigobello.model.ClientModel;
import com.proyecto.ecommerceRigobello.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

   @Autowired
    ClientRepository clientRepository;

   public ClientModel create(ClientModel newClient){
       return this.clientRepository.save(newClient);
   }

   public List<ClientModel> findAll(){
    return this.clientRepository.findAll();
   }

   public ClientModel update(ClientModel client, Long id){
       Optional<ClientModel> clientBD= this.clientRepository.findById(id);
       if (clientBD.isPresent()){
           ClientModel c = clientBD.get();
           c.setLastname(client.getLastname());
           c.setName(client.getName());
           return this.clientRepository.save(c);
       }else{
           return null;
       }
   }

   public void delete (Long id){
       this.clientRepository.deleteById(id);
   }


}
