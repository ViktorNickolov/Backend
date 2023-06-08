package com.bms.clinicmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class PatientCaseDto {
        String id;
        LocalDateTime startTime;
        LocalDateTime endTime;
        Boolean inProgress;
        Double totalCost;
        Double amountPaid;
        List<PatientCaseAppointmentDto> appointments;
        List<PatientCaseDocumentDto> documents;
}
