package com.bms.clientmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientCaseDocumentDto {
        String id;
        String documentInternalId;
        String name;
        String url;
        String detail;
        String appointmentId;
        String patientId;
}
