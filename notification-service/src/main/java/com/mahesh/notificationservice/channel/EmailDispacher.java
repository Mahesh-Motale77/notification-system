package com.mahesh.notificationservice.channel;

import com.mahesh.notificationservice.dto.request.EventRequest;
import com.mahesh.notificationservice.model.NotificationDetails;
import com.mahesh.notificationservice.service.TemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailDispacher {

    private final JavaMailSender mailSender;
    private final TemplateService templateService;

    @Value("${notification.test.mail}")
    private String mailTo;

    @Value("${spring.mail.username}")
    private String mailFrom;

    public void sendMail(EventRequest eventRequest){
        log.info("Inside EmailDispacher --> sendMail() : EventRequest : {}", eventRequest);

        String body = templateService.buildMessage(eventRequest, NotificationDetails.Channel.EMAIL);
        String subject = templateService.buildSubject(eventRequest, NotificationDetails.Channel.EMAIL);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailFrom);
        message.setTo(mailTo);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

        log.info("Email Sent for userId {} | orderId : {} | orderStatus : {}", eventRequest.getUserId(),
                eventRequest.getOrderId(), eventRequest.getOrderStatus());
    }


}
