package com.mahesh.managementapi.contoller;

import com.mahesh.managementapi.dto.request.TemplateRequest;
import com.mahesh.managementapi.service.TemplateService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/template/api")
public class NotificationTemplateController {

    private final TemplateService templateService;

    @PostMapping(value = "/v1/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerTemplate(@RequestBody TemplateRequest templateRequest){
        log.info("Inside NotificationTemplateController -> registerTemplate() : TemplateRequest : {}",templateRequest);
        return ResponseEntity.ok(templateService.saveTemplate(templateRequest));
    }

    @PostMapping(value = "/v1/get", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTemplate(@RequestBody TemplateRequest templateRequest){
        log.info("Inside NotificationTemplateController -> getTemplate() : TemplateRequest : {}",templateRequest);
        return ResponseEntity.ok(templateService.getTemplate(templateRequest));
    }
}
