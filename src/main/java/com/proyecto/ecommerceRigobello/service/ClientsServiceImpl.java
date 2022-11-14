package com.proyecto.ecommerceRigobello.service;


import com.proyecto.ecommerceRigobello.builder.ClientsBuilder;
import com.proyecto.ecommerceRigobello.controllerExceptions.ClientAlreadyExistsException;
import com.proyecto.ecommerceRigobello.externRepo.DateApi;
import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.entities.ClientsModel;
import com.proyecto.ecommerceRigobello.model.request.ClientsRequest;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;
import com.proyecto.ecommerceRigobello.repository.ClientsRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.ClientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientsServiceImpl implements ClientsService {

    private final ClientsRepository clientsRepository;

    @Override
    public ClientsResponse create(ClientsRequest client) throws ApiException, ClientAlreadyExistsException {
            ClientsModel wanted = clientsRepository.findByDni(client.getDni());
            if (wanted == null) {
                ClientsModel clientToSave = ClientsBuilder.requestToEntity(client);
                clientToSave.setHigh_date(new DateApi().getDate().getCurrentDateTime());
                ClientsModel entity = clientsRepository.save(clientToSave);
                return ClientsBuilder.entityToResponse(entity);
            }
            else{
                throw new ClientAlreadyExistsException("El cliente ya existe");
            }
    }
    @Override
    public List<ClientsResponse> findAll(){
        List<ClientsModel> clientsListEntities = clientsRepository.findAll();
        return ClientsBuilder.entityToResponseList(clientsListEntities);
   }

    @Override
    public ClientsResponse findByDni(Long dni) throws ApiException{
        try {
            ClientsModel client = clientsRepository.findById(dni).orElse(null);
            if (client != null) {
                return ClientsBuilder.entityToResponse(client);
            } else {
                throw new ApiException("Cliente inexistente");
            }
        }
        catch (Exception e){
            throw new ApiException (e.getMessage());
        }

    }
   public void delete (Long id){
       this.clientsRepository.deleteById(id);
   }

}
