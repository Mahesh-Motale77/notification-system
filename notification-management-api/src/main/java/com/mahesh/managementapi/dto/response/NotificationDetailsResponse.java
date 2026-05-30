package com.mahesh.managementapi.dto.response;

import com.mahesh.managementapi.vo.EventRequestVo;
import com.mahesh.managementapi.vo.NotificationDetailsVo;
import com.mahesh.managementapi.vo.OrderVo;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NotificationDetailsResponse {

    private String statusCode;
    private String message;
    private String requestUUID;
    private List<NotificationDetailsVo> notificatioDetails;

}
