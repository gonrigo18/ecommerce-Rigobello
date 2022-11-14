package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.builder.ClientsBuilder;
import com.proyecto.ecommerceRigobello.builder.SaleBuilder;
import com.proyecto.ecommerceRigobello.externRepo.DateApi;
import com.proyecto.ecommerceRigobello.handle.ApiException;
import com.proyecto.ecommerceRigobello.model.entities.*;
import com.proyecto.ecommerceRigobello.model.request.SaleRequest;
import com.proyecto.ecommerceRigobello.model.response.ClientsResponse;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;
import com.proyecto.ecommerceRigobello.repository.SaleRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.ClientsService;
import com.proyecto.ecommerceRigobello.service.abstraction.ProductsService;
import com.proyecto.ecommerceRigobello.service.abstraction.SaleService;
import com.proyecto.ecommerceRigobello.service.abstraction.Sale_detailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ClientsService clientsService;
    private final Sale_detailService sale_detailService;
    private final ProductsService productsService;


    public SaleResponse create(SaleRequest c) throws ApiException {
        try{
            SaleModel entity = new SaleModel();
            entity.setIssue_date(new DateApi().getDate().getCurrentDateTime());
            entity.setClient(ClientsBuilder.ResponseToEntity(clientsService.findByDni(c.getDni())));

            for (int i = 0; i < c.getDetail().size(); i++) {
                long prod = c.getDetail().get(i).getProductDetail();
                int cant = c.getDetail().get(i).getQuantity();
                productsService.findByProductAndQuantity(prod, cant);
            }

            for (int i = 0; i < c.getDetail().size(); i++) {
                Sale_detailResponse response = sale_detailService.addToCart(c.getDetail().get(i));
            }
            entity.setTotal(calculateTotal(c));
            saleRepository.save(entity);
            return SaleBuilder.entityToResponse(entity);

        }
        catch (Exception e){
            throw new ApiException(e.getMessage());
        }
    }

    public BigDecimal calculateTotal (SaleRequest c) throws ApiException {

        try {
            BigDecimal totalIssue = new BigDecimal(0);
            for (int i = 0; i < c.getDetail().size(); i++) {
                int quantity = c.getDetail().get(i).getQuantity();
                Long id_prod = c.getDetail().get(i).getProductDetail();
                ProductsResponse p = productsService.findBySku(id_prod);
                BigDecimal totalDetail = p.getSale_price();
                totalIssue = totalIssue.add((totalDetail.multiply(BigDecimal.valueOf(quantity))));
            }
            return totalIssue;
        }
        catch (Exception e){
            throw new ApiException(e.getMessage());
        }

    }

    @Override
    public List<SaleResponse> findAll(){
        List<SaleModel> clientsListEntities = saleRepository.findAll();
        return SaleBuilder.entityToResponseList(clientsListEntities);
    }



}

