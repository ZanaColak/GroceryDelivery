package com.example.grocerydelivery.service;

import com.example.grocerydelivery.model.Delivery;
import com.example.grocerydelivery.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    public List<Delivery> getListOfDeliveries(){
        return deliveryRepository.findAll();
    }

    public Delivery addDeliveryInfo(Delivery delivery){
        return deliveryRepository.save(delivery);
    }

    public Delivery updateDeliveryInfo(int id, Delivery delivery){
        Optional<Delivery> retrieveDelivery = deliveryRepository.findById(id);
        if (retrieveDelivery.isPresent()){
            retrieveDelivery.get().setDeliveryDate(delivery.getDeliveryDate());
            retrieveDelivery.get().setFromWarehouse(delivery.getFromWarehouse());
            retrieveDelivery.get().setDestination(delivery.getDestination());
            return deliveryRepository.save(retrieveDelivery.get());
        }
        else {
            throw new RuntimeException("failure");
        }
    }

    public void deleteDeliveryInfo(int id){
        deliveryRepository.deleteById(id);
    }
}
