package com.mahesh.notificationservice.service;

import com.mahesh.notificationservice.dto.request.EventRequest;

public interface NotificationService {

    void processForNotification(EventRequest eventRequest);
}
