package com.proyecto.ecommerceRigobello.model;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class ProductsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name ="sku")
    private String sku;

    @Column (name ="description")
    private String description;

    @Column (name = "purchase_price")
    private Double purchase_price;

    @Column (name = "sale_price")
    private Double sale_price;

    @Column (name ="stock")
    private int stock;

    @Column (name = "high_date")
    private String high_date;

    @OneToMany (mappedBy = "products", cascade = CascadeType.ALL)
    private List<Sale_detailModel> sale_detail;


}
