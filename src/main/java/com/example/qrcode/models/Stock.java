package com.example.qrcode.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ProductLocationId.class)
@Table(name = "stock")
public class Stock implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnoreProperties("stocks")
//    @JsonManagedReference
//    @JsonIgnore
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @JsonIgnoreProperties("stocks")
//    @JsonManagedReference
//    @JsonBackReference
    private Location location;

    @JoinColumn(name = "quantity",nullable = false)
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
