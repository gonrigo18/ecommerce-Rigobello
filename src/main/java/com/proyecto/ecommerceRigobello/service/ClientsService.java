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
   ClientsRepository clientRepository;

   public ClientsModel create(ClientsModel newClient){
       return this.clientRepository.save(newClient);
   }

   public List<ClientsModel> findAll(){
    return this.clientRepository.findAll();
   }

   public ClientsModel update(ClientsModel client, Long id) throws ResourceNotFoundException {
       Optional<ClientsModel> clientBD= this.clientRepository.findById(id);
       if (clientBD.isPresent()){
           ClientsModel c = clientBD.get();
           c.setLastname(client.getLastname());
           c.setName(client.getName());
           return this.clientRepository.save(c);
       }else{
           throw new ResourceNotFoundException("El cliente no existe");
       }
   }

   public void delete (Long id){
       this.clientRepository.deleteById(id);
   }


}
