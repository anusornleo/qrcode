package com.example.qrcode.controller;

import com.example.qrcode.models.Product;
import com.example.qrcode.models.ProductLocationId;
import com.example.qrcode.models.Stock;
import com.example.qrcode.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    final
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // get all of product
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProduct() {
        return productService.getAllProduct();
    }

    // get by id
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Product> getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewProduct(@RequestBody Product product) {
        Product p = new Product(product.getId(),product.getName(),product.getDetail(),product.getPrice(),product.getImage());
        System.out.println(product.getStocks());
        productService.saveProduct(product);
//        return product.toString();
    }
}
