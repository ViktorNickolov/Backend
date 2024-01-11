package com.bms.clientmanagementsystem.dto.converter;

import com.bms.clientmanagementsystem.dto.ClientCaseAppointmentDto;
import com.bms.clientmanagementsystem.model.Appointment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientCaseAppointmentDtoConverter {
    public ClientCaseAppointmentDto convert(Appointment from) {
        return new ClientCaseAppointmentDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getStatus() != null ? from.getStatus().getId() : null
        );
    }

    public List<ClientCaseAppointmentDto> convert(List<Appointment> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
