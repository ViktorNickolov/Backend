package com.bms.clinicmanagementsystem.dto.converter;

import com.bms.clinicmanagementsystem.dto.StatusAppointmentDto;
import com.bms.clinicmanagementsystem.model.Appointment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusAppointmentDtoConverter {
    public StatusAppointmentDto convert(Appointment from) {
        return new StatusAppointmentDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getPatientCase() != null ? from.getPatientCase().getId() : null
        );
    }

    public List<StatusAppointmentDto> convert(List<Appointment> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
