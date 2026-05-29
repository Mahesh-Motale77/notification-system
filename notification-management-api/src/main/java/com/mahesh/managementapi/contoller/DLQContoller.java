package com.mahesh.managementapi.contoller;

import com.mahesh.managementapi.dto.response.DLQRetryResponse;
import com.mahesh.managementapi.dto.response.NotificationDetailsResponse;
import com.mahesh.managementapi.service.DLQRetryService;
import com.mahesh.managementapi.service.DLQService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping(value = "/dlq/api")
@Slf4j
@RequiredArgsConstructor
public class DLQContoller {

    private final DLQService dlqService;
    private final DLQRetryService dlqRetryService;

    @GetMapping(value = "/v1/records", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NotificationDetailsResponse>> getAllDlqNotifications(){
        log.info("Inside DLQContoller --> getAllDlqNotifications()");
        return ResponseEntity.ok(dlqService.getAllDlqNotifications());
    }


    @PostMapping(value = "/v1/retry/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DLQRetryResponse> retryDLQRecords(@PathVariable("orderId") String orderId){
        log.info("Inside DLQContoller --> retryDLQRecords()");
        return ResponseEntity.ok(dlqRetryService.retryDLQRecords(orderId));
    }


}
