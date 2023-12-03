package com.example.grocerydelivery.service;

import com.example.grocerydelivery.model.ProductOrder;
import com.example.grocerydelivery.repository.ProductOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductOrderService {
    private ProductOrderRepository productOrderRepository;

    public List<ProductOrder> getListOfOrderProducts() {
        return productOrderRepository.findAll();
    }

    public void addProductOrder(ProductOrder productOrder) {
        productOrderRepository.save(productOrder);
    }

    public ProductOrder updateProductOrder(int id, ProductOrder updatedProductOrder) {
        Optional<ProductOrder> existingProductOrderOptional = productOrderRepository.findById(id);

        if (existingProductOrderOptional.isPresent()) {
            ProductOrder existingProductOrder = existingProductOrderOptional.get();

            existingProductOrder.setQuantity(updatedProductOrder.getQuantity());

            return productOrderRepository.save(existingProductOrder);
        } else {
            return null;
        }
    }

    public void deleteProductOrder(ProductOrder productOrder) {
        productOrderRepository.delete(productOrder);
    }
}
