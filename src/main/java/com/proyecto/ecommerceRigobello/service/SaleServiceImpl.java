package com.proyecto.ecommerceRigobello.service;

import com.proyecto.ecommerceRigobello.controllerExceptions.ResourceNotFoundException;
import com.proyecto.ecommerceRigobello.dto.ProductDTO;
import com.proyecto.ecommerceRigobello.dto.SaleDTO;
import com.proyecto.ecommerceRigobello.externRepo.ClockWorldRest;
import com.proyecto.ecommerceRigobello.model.mappers.SaleMapper;
import com.proyecto.ecommerceRigobello.model.response.SaleResponse;
import com.proyecto.ecommerceRigobello.model.entities.*;
import com.proyecto.ecommerceRigobello.repository.ClientsRepository;
import com.proyecto.ecommerceRigobello.repository.ProductsRepository;
import com.proyecto.ecommerceRigobello.repository.SaleRepository;
import com.proyecto.ecommerceRigobello.repository.Sale_detailRepository;
import com.proyecto.ecommerceRigobello.saleJson.ProductJson;
import com.proyecto.ecommerceRigobello.saleJson.SaleJson;
import com.proyecto.ecommerceRigobello.service.abstraction.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleRepository saleRepository;
    @Autowired
    ClientsRepository clientsRepository;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    Sale_detailRepository sale_detailRepository;

    @Autowired
    private ClockWorldRest clockWorldApi;

    public SaleModel create(SaleModel newSale) {
        return this.saleRepository.save(newSale);
    }

    public List<SaleModel> findAll() {
        return this.saleRepository.findAll();
    }

    @Override
    public SaleResponse findById(Long id) throws Exception {
        return SaleMapper.saleResponse(saleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("La venta no existe")));
    }

    @Override
    public SaleDTO invoiceSale(SaleJson sale) throws Exception {         //Hacer la venta, calcular stock, verificar
        SaleDTO saleDTO = new SaleDTO();
        SaleModel saleRepo = new SaleModel();
        if (clientsRepository.findById(sale.getClientID()).orElse(null) != null) {       //Si el numero del cliente existe, entonces se verifica
            if (existProduct(sale.getProducts())) {
                if (checkStock(sale.getProducts())) {     //Comprobar Stock
                    saleRepo.setId(newIdSale(saleRepository.findAll()));
                    saleRepo.setClient(returnClient(this.clientsRepository.findAll(), sale.getClientID()));
                    saleRepo.setSale_Detail(transformProducts(sale.getProducts(), saleRepo));
                    try {                                                                  //Intenta obtener una fecha valida
                        saleRepo.setHigh_date(clockWorldApi.getDate());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    //Convertimos para mostrarlo en pantalla
                    saleDTO = giveArguments(saleRepo);
                    saleDTO.setDescription(convertList(saleRepo.getSale_Detail()));
                    saleDTO.setTotal(totalSum(saleDTO.getDescription()));
                    saleDTO.setQuantity(totalProd(saleDTO.getDescription()));
                    calculateAndSaveStock(saleRepo.getSale_Detail());
                    //Guardamos
                    saleRepository.save(saleRepo);
                    return saleDTO;
                } else {
                    throw new Exception("No hay stock disponible de alguno de los productos");
                }
            } else {
                throw new Exception("No existe alguno de los productos");
            }
        } else {
            throw new Exception("No existe el cliente");
        }
    }

    public List<ProductDTO> giveProduct(SaleModel c) {                    //Funcion auxiliar para pasar una lista de productos de un formato a otro
        List<Sale_detailModel> ListAllProducts = this.sale_detailRepository.findAll();
        List<Sale_detailModel> productList = new ArrayList<>();
        List<ProductDTO> productListDTO = new ArrayList<>();
        for (Sale_detailModel listAllProduct : ListAllProducts) {                          //Dentro de toda la base de lineas, busca aquellos productos que tengan el comprobante ID que se requiere y los pasa a una nueva lista auxialiar
            if (giveAllProducts(c.getId(), listAllProduct)) {
                productList.add(listAllProduct);
            }
        }
        ProductDTO product = new ProductDTO();
        for (Sale_detailModel sale_detailModel : productList) {
            product.setDescription(sale_detailModel.getDescription());
            product.setSale_price(sale_detailModel.getSubtotal());
            product.setStock(sale_detailModel.getQuantity());
            product.setId(sale_detailModel.getId());
            productListDTO.add(new ProductDTO((product.getDescription()), product.getStock(), product.getSale_price(), product.getId()));
        }
        return productListDTO;
    }
    public Boolean giveAllProducts(Long saleId, Sale_detailModel prod){
        return Objects.equals(prod.getSaleId(), saleId);
    }


        public SaleDTO giveArguments (SaleModel c){               //Convertimos el comprobante del repositorio en un objeto con estructura json
            SaleDTO saleDTO = new SaleDTO();
            saleDTO.setId(c.getId());
            saleDTO.setDate(c.getHigh_date());
            saleDTO.setClientID(c.getClient().getId());
            saleDTO.setDescription(giveProduct(c));
            saleDTO.setTotal(totalSum(giveProduct(c)));
            saleDTO.setQuantity(totalProd(saleDTO.getDescription()));
            return saleDTO;
        }

        public Long newIdSale (List < SaleModel > sale) {
            {           //Calcula el id nuevo del comprobante para no sobreescribir otro comprobante
                return (long) (sale.size() + 1);
            }
        }

        public List<Sale_detailModel> transformProducts (List < ProductJson > prod, SaleModel saleId)
        {    //Funcion para convertir la lista de datos de pantalla al formato a trabajar
            List<Sale_detailModel> transform = new ArrayList<>();
            for (ProductJson productJson : prod) {
                transform.add(new Sale_detailModel(productsRepository.findById(productJson.getProductId()).get().getDescription(), productsRepository.findById(productJson.getProductId()).get().getSale_price(), productJson.getQuantity(), productJson.getProductId(), saleId));
            }
            return transform;
        }

        public double totalSum(List<ProductDTO> list){     //Suma los precios de los producto para obtener el total
        double totalSum = 0;
            for (ProductDTO productDTO : list) {
                totalSum += productDTO.getSale_price() * productDTO.getStock();
            }
        return totalSum;
    }
        public int totalProd(List<ProductDTO> list){        //Suma la cantidad de productos para obtener la cantidad de productos que se lleva el cliente
        int totalProd = 0;
            for (ProductDTO productDTO : list) {
                totalProd += productDTO.getStock();
            }
        return totalProd;
    }
    public boolean existProduct(List<ProductJson> prod){            //Busca en el repositorio si existen los id de los productos
        boolean flag = true;
        for (ProductJson productJson : prod) {
            for (int e = 0; e < this.productsRepository.findAll().size(); e++) {
                if (this.productsRepository.findById(productJson.getProductId()).orElse(null) == null) {
                    flag = false;
                }
            }
        }
        return flag;
    }
    public boolean checkStock(List<ProductJson> prod){        //Comprobamos que los items requeridos esten en stock, sino anulamos la compra
        boolean flag = true;
        List<ProductsModel> stock = this.productsRepository.findAll();
        for(int i = 0; i<prod.size() && flag; i++ ){
            for(int e = 0; e<stock.size()&& flag; e++){
                if(prod.get(i).getProductId().equals(stock.get(e).getId())){            //Busco que los productos tengan igual productoId para fijar si hay stock de ese producto
                    if(prod.get(i).getQuantity()>stock.get(e).getStock()){
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }

    public void calculateAndSaveStock(List<Sale_detailModel> prod){          //Calcula el stock de los productos solicitados y se guarda el nuevo stock
        List<ProductsModel> stock = this.productsRepository.findAll();
        List<ProductsModel> newStock = new ArrayList<>();
        for (Sale_detailModel sale_detailModel : prod) {
            for (ProductsModel productsModel : stock) {
                if (sale_detailModel.getId().equals(productsModel.getId())) {            //Busco que los productos tengan igual productoId para fijar si hay stock de ese producto
                    productsModel.setStock(productsModel.getStock() - sale_detailModel.getQuantity());
                    newStock.add(productsModel);
                }
            }
        }
        this.productsRepository.saveAllAndFlush(newStock);
    }

    public ClientsModel returnClient(List<ClientsModel> clients, Long clientId){                      //Busca el cliente por ID y lo devuelve
        ClientsModel client = new ClientsModel();
        for (ClientsModel clientsModel : clients) {
            if (clientsModel.getId().equals(clientId)) {
                client = clientsModel;
            }
        }
        return client;
    }

    public List<ProductDTO> convertList(List<Sale_detailModel> productsList){            //Funcion auxiliar para convertir una lista de repositorio a una lista para mostrar
        List<ProductDTO> list = new ArrayList<>();
        for (Sale_detailModel sale_detailModel : productsList) {
            list.add(new ProductDTO(sale_detailModel.getDescription(), sale_detailModel.getQuantity(), sale_detailModel.getSubtotal(), sale_detailModel.getId()));//String nombre, int cantidad, double precio, int productoId
        }
        return list;
    }



}

