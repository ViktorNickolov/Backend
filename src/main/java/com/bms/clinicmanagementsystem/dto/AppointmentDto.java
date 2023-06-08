package com.bms.clinicmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AppointmentDto {
    String id;
    LocalDateTime startTimed;
    LocalDateTime endTimed;
    String statusIdd;
    String patientCaseIdd;
}
