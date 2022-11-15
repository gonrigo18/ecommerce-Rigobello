package com.proyecto.ecommerceRigobello.model.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "products")
public class ProductsModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Id
    @Column
    private String sku;
    @Column
    private String description;
    @Column
    private Integer stock;
    @Column
    private double buy_price;
    @Column
    private double sale_price;
    @Column
    private LocalDate high_Date;
    public String NewProduct() {
        return String.format("Producto creado:%nID: %s | SKU: %s | Descripción: %s | Stock: %s| Precio Compra: $%s | Precio Venta: $%s | Fecha Alta: %s",
                this.id, this.sku, this.description, this.stock, this.buy_price, this.sale_price, this.high_Date);
    }

    public String updatedProduct() {
        return String.format("Producto de ID %s actualizado:%nSKU: %s | Descripción: %s | Stock: %d | Precio Compra: $%s | Precio Venta: $%s | Fecha Alta: %s",
                this.id, this.sku, this.description, this.stock, this.buy_price, this.sale_price, this.high_Date);
    }

}
