package com.example.qrcode.controller;

import com.example.qrcode.models.Product;
import com.example.qrcode.models.ProductLocationId;
import com.example.qrcode.models.Stock;
import com.example.qrcode.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    // get by id
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<Optional<Product>>  getProductById(@PathVariable("id") int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // post new product
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.ok(200);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public ResponseEntity<?> putProduct(@PathVariable int id, @RequestBody Product body) {
        Optional<Product> product = productService.updateProduct(id, body);
        if(!product.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(200);
    }
}
