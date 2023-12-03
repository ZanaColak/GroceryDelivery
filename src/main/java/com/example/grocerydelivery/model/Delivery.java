package com.example.grocerydelivery.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;
    private LocalDate deliveryDate;
    private String fromWarehouse;
    private String destination;

    @OneToMany(mappedBy = "delivery")
    @JsonBackReference
    private Set<ProductOrder> productOrders = new HashSet<>();

}
