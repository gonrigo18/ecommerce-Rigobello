package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.builder.ClientsBuilder;
import com.proyecto.ecommerceRigobello.builder.SaleBuilder;
import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.dto.SaleDTO;
import com.proyecto.ecommerceRigobello.dto.Sale_DetailDTO;
import com.proyecto.ecommerceRigobello.externRepo.DateApi;
import com.proyecto.ecommerceRigobello.model.entities.*;
import com.proyecto.ecommerceRigobello.model.request.SaleRequest;
import com.proyecto.ecommerceRigobello.model.response.ProductsResponse;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import com.proyecto.ecommerceRigobello.model.response.Sale_detailResponse;
import com.proyecto.ecommerceRigobello.repository.SaleRepository;
import com.proyecto.ecommerceRigobello.service.abstraction.ClientsService;
import com.proyecto.ecommerceRigobello.service.abstraction.ProductsService;
import com.proyecto.ecommerceRigobello.service.abstraction.SaleService;
import com.proyecto.ecommerceRigobello.service.abstraction.Sale_detailService;
import com.proyecto.ecommerceRigobello.validators.SaleValidations;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private  SaleRepository saleRepository;
    @Autowired
    private  ClientsServiceImpl clientsService;
    @Autowired
    private  Sale_detailServiceImpl sale_detailService;
    @Autowired
    private  ProductsServiceImpl productsService;
    @Autowired
    private SaleValidations saleValidations;


    @Override
    public Optional<SaleModel> findById(Long id) throws Exception {
        saleValidations.checkId(id);
        Optional<SaleModel> sale = this.saleRepository.findById(id);
        if(sale.isPresent()) {
            return sale;
        } else {
            throw new ResourceNotFoundException("No existe la venta");
        }
    }
    @Override
    public List<Sale_detailModel> findByDetailId(Long id) throws Exception {
        return sale_detailService.getSale_detail(id);
    }
    @Override
    public List<SaleModel> findAll() throws Exception {
        List<SaleModel> sales = this.saleRepository.findAll();
        this.saleValidations.checkList(sales);
        return sales;
    }
    @Override
    public List<SaleModel> findByClientId(Long clientId) throws Exception {
        Optional<SaleModel> client = clientsService.findByClientId(clientId);
        if(client.isPresent()) {
            return this.saleRepository.findByClientId(clientId);
        }
        else {
            throw new ResourceNotFoundException("No se encontró el cliente en la Base de Datos.");
        }
    }

    @Override
    public SaleModel create(SaleDTO newSale) throws Exception {
        ClientsModel client = this.clientsService.findById(newSale.getClientId()).get();
        saleValidations.checkDTO(newSale);
        double total = 0.0;
        SaleModel sale = new SaleModel(LocalDate.now(), total, client);
        sale = this.saleRepository.save(sale);

        for (Sale_DetailDTO detail : newSale.getDetail()) {
            ProductsModel product = this.productsService.findById(detail.getProductId()).get();
            double subtotal = detail.getQuantity() * product.getSale_price();
            this.productsService.updateStock(product.getId(), detail.getQuantity(), "-");
            Sale_detailModel det = new Sale_detailModel(sale, product, detail.getQuantity(), subtotal);
            this.sale_detailService.create(det);
            total += subtotal;
        }
        sale.setTotal(total);
        return update(sale, sale.getId());
    }

    @Override
    public SaleModel update(SaleModel sale, Long id) throws Exception {
        Optional<SaleModel> saleDB = this.saleRepository.findById(id);
        saleValidations.check(sale);
        if(saleDB.isPresent()) {
            SaleModel s = saleDB.get();
            s.setClientId(sale.getClientId());
            s.setTotal(sale.getTotal());
            s.setHigh_date(sale.getHigh_date());
            return this.saleRepository.save(s);
        } else {
            throw new ResourceNotFoundException("La venta no se encuentra");
        }
    }

}

