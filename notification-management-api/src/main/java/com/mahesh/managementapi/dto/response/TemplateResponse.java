package com.mahesh.managementapi.dto.response;

import com.mahesh.managementapi.dto.request.TemplateRequest;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@ToString
public class TemplateResponse {
    private String statusCode;
    private String message;
    private TemplateRequest Data;
}
