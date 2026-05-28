package com.mahesh.orderservice.controller;

import com.mahesh.orderservice.dto.request.OrderRequest;
import com.mahesh.orderservice.dto.response.OrderResponse;
import com.mahesh.orderservice.service.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping(value = "/order/v1")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody @Validated OrderRequest orderRequest){
        log.info("Inside OrderController --> createOrder() : orderRequest : {}", orderRequest);
        return ResponseEntity.ok(orderService.createOrder(orderRequest));
    }


}
