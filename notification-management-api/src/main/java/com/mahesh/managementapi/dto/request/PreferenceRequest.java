package com.mahesh.managementapi.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.kafka.common.protocol.types.Field;

@Data
@ToString
@Builder
public class PreferenceRequest {
    private String userId;
    private String channel;
    private String notificationType;
    private Boolean isEnable;
}
