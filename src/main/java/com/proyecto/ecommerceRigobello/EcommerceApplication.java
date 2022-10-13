package com.proyecto.ecommerceRigobello;

import com.proyecto.ecommerceRigobello.model.ClientModel;
import com.proyecto.ecommerceRigobello.repository.ClientRepository;
import com.proyecto.ecommerceRigobello.repository.Sale_detailRepository;
import com.proyecto.ecommerceRigobello.repository.ProductsRepository;
import com.proyecto.ecommerceRigobello.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	Sale_detailRepository detalle_ventaRepository;
	@Autowired
	ProductsRepository productosRepository;
	@Autowired
	SaleRepository ventaRepository;

	public static void main(String[] args) { SpringApplication.run(EcommerceApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
	}
}
