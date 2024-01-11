package com.bms.clientmanagementsystem.request.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDocumentRequest {
    private String name;
    private String detail;
    private String appointmentId;
    private String clientCaseId;
    private String clientId;
}
