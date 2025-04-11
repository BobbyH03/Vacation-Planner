package com.d288.d288backendprogramming.services;

import com.d288.d288backendprogramming.entities.Cart;
import com.d288.d288backendprogramming.entities.CartItem;
import com.d288.d288backendprogramming.entities.Customer;
import com.d288.d288backendprogramming.entities.StatusType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
    @Autowired
    private Customer customer;
    @Autowired
    private Cart cart;
    @Autowired
    private Set<CartItem> cartItems;
    @Autowired
    private StatusType status;
}
