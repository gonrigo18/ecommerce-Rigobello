package com.proyecto.ecommerceRigobello.service;


import com.proyecto.ecommerceRigobello.controllerExceptions.IllegalArgumentException;
import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceAlreadyExistsException;
import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.model.entities.SaleModel;
import com.proyecto.ecommerceRigobello.repository.ClientsRepository;
import com.proyecto.ecommerceRigobello.repository.SaleRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.ClientsService;
import com.proyecto.ecommerceRigobello.validators.ClientsValidations;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService {
    @Autowired
    private  ClientsRepository clientsRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ClientsValidations clientsValidations;

    @Override
    public Optional<ClientsModel> findById(Long id) throws Exception
    {
        this.clientsValidations.validateId(id);

        Optional<ClientsModel> client = this.clientsRepository.findById(id);
        if(client.isPresent()) {
            return client;
        }
        else {
            throw new ResourceNotFoundException("No existe cliente");
        }
    }
    @Override
    public ClientsModel findByDni(String dni) throws ResourceNotFoundException {
        ClientsModel client = this.clientsRepository.findByDni(dni);
        this.clientsValidations.validateDNI(client);
        return client;
    }
    @Override
    public List<ClientsModel> findAll() throws Exception {
        List<ClientsModel> clients = this.clientsRepository.findAll();
        this.clientsValidations.checkList(clients);
        return clients;
    }
    @Override
    public String create(ClientsModel newClient) throws Exception {
        ClientsValidations.checkFields(newClient);
        boolean exist = this.clientsRepository.findByDni(newClient.getDni()) != null;
        if(exist) {
            throw new ResourceAlreadyExistsException("El cliente ya existe");
        }else {
            clientsRepository.save(newClient);
            return newClient.NewClient();
        }
    }
    @Override
    public String update(ClientsModel client, Long id) throws Exception {
        ClientsValidations.checkFields(client);
        Optional<ClientsModel> clientDB = this.clientsRepository.findById(id);
        if(clientDB.isPresent()) {
            ClientsModel cli = clientDB.get();
            cli.setDni(client.getDni());
            cli.setName(client.getName());
            cli.setLastname(client.getLastname());
            cli.setBirth_date(client.getBirth_date());
            this.clientsRepository.save(cli);
            return client.UpdatedClient();
        }
        else
            throw new ResourceNotFoundException("El cliente  no existe");
    }
    @Override
    public String deleteById(Long id) throws Exception {
        if(id == null) {
            throw new IllegalArgumentException("No se ingresó ID.");
        }
        Optional<ClientsModel> client = this.clientsRepository.findById(id);
        if(client.isEmpty()) {
            throw new ResourceNotFoundException("No se encontró el cliente.");
        }
        List<SaleModel> byClientId = saleRepository.findByClientId(id);
        if(byClientId.size() != 0) {
            throw new ResourceAlreadyExistsException("Imposible eliminar");
        }
        this.clientsRepository.deleteById(id);
        return "ok";
    }

}
