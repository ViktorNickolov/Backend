package com.bms.clientmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StatusAppointmentDto {
        String id;
        LocalDateTime startTime;
        LocalDateTime endTime;
        String patientCaseId;
}
