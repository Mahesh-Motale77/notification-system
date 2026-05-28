package com.mahesh.orderservice.dto.response;

import com.mahesh.orderservice.model.Order;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class OrderResponse {
    private String statusCode;
    private String statusMessage;
    private String requestUUID;

    private Order data;

    public class OrderData{
        private Long userId;
        private String items;
        private Double amount;
        private Order.OrderStatus orderStatus;
    }
}
