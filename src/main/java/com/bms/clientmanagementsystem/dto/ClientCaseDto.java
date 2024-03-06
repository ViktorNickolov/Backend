package com.bms.clientmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ClientCaseDto {
        String id;
        LocalDateTime startTime;
        LocalDateTime endTime;
        Boolean inProgress;
        List<ClientCaseAppointmentDto> appointments;
        List<ClientCaseDocumentDto> documents;
}
