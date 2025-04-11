package com.d288.d288backendprogramming.services;
import com.d288.d288backendprogramming.dao.CartRepository;
import com.d288.d288backendprogramming.dao.CustomerRepository;
import com.d288.d288backendprogramming.entities.Cart;
import com.d288.d288backendprogramming.entities.CartItem;
import com.d288.d288backendprogramming.dao.CartItemRepository;
import com.d288.d288backendprogramming.entities.Customer;
import com.d288.d288backendprogramming.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        cart.setCustomer(purchase.getCustomer());

        cart.setStatus(Cart.StatusType.ordered);

        cartRepository.save(cart);

        if (cart == null || cartItems.isEmpty() || purchase.getCustomer() == null) {

            String cartEmpty = "Cart is empty";
            return new PurchaseResponse(cartEmpty);
        }
        else {
            return new PurchaseResponse(orderTrackingNumber);
        }
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}