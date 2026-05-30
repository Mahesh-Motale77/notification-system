package com.mahesh.managementapi.service;

import com.mahesh.managementapi.dto.response.NotificationDetailsResponse;

import java.util.List;

public interface DLQService {
    NotificationDetailsResponse getAllDlqNotifications();
}
