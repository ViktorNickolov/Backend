package com.bms.clinicmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PatientCaseAppointmentDto {
        String id;
        LocalDateTime startTime;
        LocalDateTime endTime;
        String statusId;
}
