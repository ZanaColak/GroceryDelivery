package com.example.grocerydelivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productOrderId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "prodOrderId", referencedColumnName = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "deliveryId", referencedColumnName = "deliveryId")
    private Delivery delivery;
}
