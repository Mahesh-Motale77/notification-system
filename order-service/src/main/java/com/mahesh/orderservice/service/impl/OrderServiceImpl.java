package com.mahesh.orderservice.service.impl;

import com.mahesh.orderservice.dto.request.OrderRequest;
import com.mahesh.orderservice.dto.response.OrderResponse;
import com.mahesh.orderservice.model.Order;
import com.mahesh.orderservice.repository.OrderRepository;
import com.mahesh.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        log.info("Inside OrderServiceImpl -> createOrder() : OrderRequest : {}", request);

        // creating a new order with status as CREATED
        Order order = Order.builder()
                .orderId("ORD"+System.currentTimeMillis())
                .userId(request.getUserId())
                .orderStatus(Order.OrderStatus.CREATED)
                .amount(request.getAmount())
                .items(request.getItems())
                .build();

        Order createdOrder = orderRepository.save(order);
        log.info("Inside OrderServiceImpl -> createOrder() : Order created for userId : {}", createdOrder.getUserId());

        // call kafka producer method to publish an event


        return OrderResponse.builder()
                .statusCode("200")
                .statusMessage("Order created successfully!")
                .requestUUID(MDC.get("UUID"))
                .data(order)
                .build();
    }
}
