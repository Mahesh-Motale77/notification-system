package com.mahesh.orderservice.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.apache.kafka.common.protocol.types.Field;

@Data
@Builder
@ToString
public class OrderRequest {
    private String userId;
    private String items;
    private Double amount;
}
