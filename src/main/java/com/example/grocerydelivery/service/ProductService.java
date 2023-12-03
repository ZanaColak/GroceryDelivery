package com.example.grocerydelivery.service;

import com.example.grocerydelivery.model.Product;
import com.example.grocerydelivery.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProductByName(String productName) {
        return productRepository.findProductByName(productName);
    }

    public Product updateProduct(int id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setProductId(id);
            return productRepository.save(updatedProduct);
        } else {
            return null;
        }
    }

    public void deleteProduct(Product product){
        productRepository.delete(product);
    }
}
