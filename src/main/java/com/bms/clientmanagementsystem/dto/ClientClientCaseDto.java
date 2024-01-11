package com.bms.clientmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ClientClientCaseDto {
        String id;
        LocalDateTime startTime;
        LocalDateTime endTime;
        Boolean inProgress;
        Double totalCost;
        Double amountPaid;
}
