package com.bms.clinicmanagementsystem.dto.converter;

import com.bms.clinicmanagementsystem.dto.PatientDocumentDto;
import com.bms.clinicmanagementsystem.model.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientDocumentDtoConverter {
    public PatientDocumentDto convert(Document from) {
        return new PatientDocumentDto(
                from.getId(),
                from.getDocumentInternalId(),
                from.getName(),
                from.getUrl(),
                from.getDetail(),
                from.getAppointment() != null ? from.getAppointment().getId() : null,
                from.getPatientCase() != null ? from.getPatientCase().getId() : null
        );
    }

    public List<PatientDocumentDto> convert(List<Document> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
