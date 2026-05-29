package com.mahesh.notificationservice.repository;

import com.mahesh.notificationservice.model.NotificationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDetailsRepository extends JpaRepository<NotificationDetails, Long> {
}
