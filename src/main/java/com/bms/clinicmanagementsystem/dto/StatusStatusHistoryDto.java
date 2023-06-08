package com.bms.clinicmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StatusStatusHistoryDto {
    String id;
    LocalDateTime time;
    String description;
    String appointmentId;
}
