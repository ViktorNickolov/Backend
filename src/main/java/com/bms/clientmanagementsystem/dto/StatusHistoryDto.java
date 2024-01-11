package com.bms.clientmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StatusHistoryDto {
    String id;
    LocalDateTime time;
    String description;
    String statusId;
    String appointmentId;
}
