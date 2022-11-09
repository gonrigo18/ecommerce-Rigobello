package com.proyecto.ecommerceRigobello.service;


import com.proyecto.ecommerceRigobello.controllerExceptions.ClientAlreadyExistsException;
import com.proyecto.ecommerceRigobello.controllerExceptions.NullFieldException;
import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.model.mappers.ClientsMapper;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;
import com.proyecto.ecommerceRigobello.model.validator.ClientsValidationDTO;
import com.proyecto.ecommerceRigobello.repository.ClientsRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.ClientsService;
import com.proyecto.ecommerceRigobello.validations.ClientsValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    ClientsRepository clientsRepository;

    public ClientsModel create(ClientsModel newClient) throws Exception {
        ClientsValidationDTO flag = ClientsValidations.checkFields(newClient);
        ClientsModel clientBD = this.clientsRepository.findByDni(newClient.getDni());
        if (clientBD != null) {
            if ((newClient.getDni().equals(clientBD.getDni()))) {
                throw new ClientAlreadyExistsException(flag.Message);
            }
        }else if (flag.hasError) {
            throw new NullFieldException(flag.Message);
        }
        return this.clientsRepository.save(newClient);
    }
    public List<ClientsModel> findAll(){
    return this.clientsRepository.findAll();
   }
    @Override
    public ClientsResponse findById(Long id) throws Exception{
        return ClientsMapper.clientsYears(clientsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El cliente no existe")));
    }
    public ClientsModel update(ClientsModel client, Long id) throws Exception {
       ClientsModel clientBD= this.clientsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El cliente no existe"));
        clientBD.setLastname(client.getLastname());
        clientBD.setName(client.getName());
        clientBD.setBirth_date(client.getBirth_date());
        return this.clientsRepository.save(clientBD);
   }
   public void delete (Long id){
       this.clientsRepository.deleteById(id);
   }

}
