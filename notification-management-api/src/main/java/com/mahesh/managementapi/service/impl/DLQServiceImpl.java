package com.mahesh.managementapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahesh.managementapi.dto.response.NotificationDetailsResponse;
import com.mahesh.managementapi.model.NotificationDetails;
import com.mahesh.managementapi.repository.NotificationDetailsRepository;
import com.mahesh.managementapi.service.DLQService;
import com.mahesh.managementapi.vo.EventRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mahesh.managementapi.model.NotificationDetails.NotificationStatus.DLQ;

@Service
@RequiredArgsConstructor
@Slf4j
public class DLQServiceImpl implements DLQService {

    private final NotificationDetailsRepository notificationDetailsRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<NotificationDetailsResponse> getAllDlqNotifications() {
        log.info("Inside DLQServiceImpl --> getAllDlqNotifications()");

        List<NotificationDetails> notificationDetails = notificationDetailsRepository.findByNotificationStatus(DLQ);

        return notificationDetails
                .stream()
                .map(this::mapToNotificationDetailResponse)
                .collect(Collectors.toList());
    }

    private NotificationDetailsResponse mapToNotificationDetailResponse(NotificationDetails details) {
        EventRequestVo payload;
        try {
            payload = objectMapper.readValue(details.getPayload(), EventRequestVo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return NotificationDetailsResponse.builder()
                .orderId(details.getOrderId())
                .userId(details.getUserId())
                .items(details.getItems())
                .amount(details.getAmount())
                .channel(String.valueOf(details.getChannel()))
                .notificationStatus(String.valueOf(details.getNotificationStatus()))
                .notificationType(String.valueOf(details.getNotificationType()))
                .payload(payload)
                .errorMessage(details.getErrorMessage())
                .retryCount(details.getRetryCount())
                .createdAt(details.getCreatedAt())
                .updatedAt(details.getUpdatedAt())
                .build();
    }
}
