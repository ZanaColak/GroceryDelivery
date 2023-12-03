package com.example.grocerydelivery.controller;

import com.example.grocerydelivery.model.ProductOrder;
import com.example.grocerydelivery.service.ProductOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
@CrossOrigin
public class ProductOrderController {
    private ProductOrderService productOrderService;

    @GetMapping
    public ResponseEntity<List<ProductOrder>> getListOfOrderProducts() {
        List<ProductOrder> productOrders = productOrderService.getListOfOrderProducts();
        return new ResponseEntity<>(productOrders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addProductOrder(@RequestBody ProductOrder productOrder) {
        productOrderService.addProductOrder(productOrder);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOrder> updateProductOrder(
            @PathVariable int id,
            @RequestBody ProductOrder updatedProductOrder
    ) {
        ProductOrder updated = productOrderService.updateProductOrder(id, updatedProductOrder);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
