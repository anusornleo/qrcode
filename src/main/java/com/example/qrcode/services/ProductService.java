package com.example.qrcode.services;

import com.example.qrcode.models.Product;
import com.example.qrcode.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    final
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }


    public Optional<Product> updateProduct(int id, Product customer) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(!productOptional.isPresent()) {
            return productOptional;
        }
        customer.setId(id);
        return Optional.of(productRepository.save(customer));
    }
}
