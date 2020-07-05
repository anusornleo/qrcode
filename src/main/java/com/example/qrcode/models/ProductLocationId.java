package com.example.qrcode.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductLocationId implements Serializable {
    private int product;
    private int location;

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
