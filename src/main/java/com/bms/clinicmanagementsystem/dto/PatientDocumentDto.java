package com.bms.clinicmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientDocumentDto {
        String id;
        String documentInternalId;
        String name;
        String url;
        String detail;
        String appointmentId;
        String patientCaseId;
}
