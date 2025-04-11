package com.d288.d288backendprogramming.services;

import lombok.Data;
import com.d288.d288backendprogramming.entities.StatusType;

@Data
public class PurchaseResponse {
    private final String orderTrackingNumber;
    private StatusType status;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
