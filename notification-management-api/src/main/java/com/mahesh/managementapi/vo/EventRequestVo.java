package com.mahesh.managementapi.vo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EventRequestVo {

    private String orderId;
    private String userId;
    private String items;
    private Double amount;

    private String orderStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
