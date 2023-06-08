package com.bms.clinicmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentTypeDocumentDto {
        String id;
        String documentInternalI;
        String name;
        String url;
        String detail;
        String appointmentId;
        String patientCaseId;
        String patientId;
}
