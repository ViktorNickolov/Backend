package com.bms.clientmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ScheduleDto {
        String id;
        LocalDate date;
        LocalDateTime startTime;
        LocalDateTime endTime;
}
