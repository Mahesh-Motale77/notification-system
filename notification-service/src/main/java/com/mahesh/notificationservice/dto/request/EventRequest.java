package com.mahesh.notificationservice.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EventRequest {

    private String orderId;
    private String userId;
    private String items;
    private Double amount;

    private String orderStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
