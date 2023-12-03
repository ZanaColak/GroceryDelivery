package com.example.grocerydelivery.controller;

import com.example.grocerydelivery.model.Delivery;
import com.example.grocerydelivery.model.Product;
import com.example.grocerydelivery.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
@AllArgsConstructor
@CrossOrigin
public class DeliveryController {
    private DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliveries(){
        List<Delivery> deliveryList = deliveryService.getListOfDeliveries();
        return new ResponseEntity<>(deliveryList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Delivery> addProduct(@RequestBody Delivery delivery) {
        Delivery addedDeliveryInfo = deliveryService.addDeliveryInfo(delivery);
        return new ResponseEntity<>(addedDeliveryInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Delivery> updateDelivery(@PathVariable int id, @RequestBody Delivery updatedDelivery) {
        Delivery updated = deliveryService.updateDeliveryInfo(id, updatedDelivery);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
