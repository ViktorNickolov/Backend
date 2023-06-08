package com.bms.clinicmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StatusDto {
    String id;
    String name;
    List<StatusAppointmentDto> appointments;
    List<StatusStatusHistoryDto> statusHistories;
}
