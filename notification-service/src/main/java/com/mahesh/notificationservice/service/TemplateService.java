package com.mahesh.notificationservice.service;

import com.mahesh.notificationservice.dto.request.EventRequest;
import com.mahesh.notificationservice.model.NotificationDetails;
import org.apache.kafka.common.protocol.types.Field;

public interface TemplateService {

    String buildMessage(EventRequest eventRequest, NotificationDetails.Channel channel);

    String buildSubject(EventRequest eventRequest, NotificationDetails.Channel channel);

}
