package com.bms.clinicmanagementsystem.dto.converter;

import com.bms.clinicmanagementsystem.dto.PatientCaseAppointmentDto;
import com.bms.clinicmanagementsystem.model.Appointment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientCaseAppointmentDtoConverter {
    public PatientCaseAppointmentDto convert(Appointment from) {
        return new PatientCaseAppointmentDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getStatus() != null ? from.getStatus().getId() : null
        );
    }

    public List<PatientCaseAppointmentDto> convert(List<Appointment> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
