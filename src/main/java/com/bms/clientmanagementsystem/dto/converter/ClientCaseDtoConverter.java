package com.bms.clientmanagementsystem.dto.converter;

import com.bms.clientmanagementsystem.dto.ClientCaseDto;
import com.bms.clientmanagementsystem.model.ClientCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientCaseDtoConverter {
    private final ClientCaseAppointmentDtoConverter clientCaseAppointmentDtoConverter;
    private final ClientCaseDocumentDtoConverter clientCaseDocumentDtoConverter;

    public ClientCaseDtoConverter(ClientCaseAppointmentDtoConverter clientCaseAppointmentDtoConverter,
                                  ClientCaseDocumentDtoConverter clientCaseDocumentDtoConverter) {
        this.clientCaseAppointmentDtoConverter = clientCaseAppointmentDtoConverter;
        this.clientCaseDocumentDtoConverter = clientCaseDocumentDtoConverter;
    }

    public ClientCaseDto convert(ClientCase from) {
        return new ClientCaseDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getInProgress(),
                from.getAppointments() != null ? clientCaseAppointmentDtoConverter.convert(from.getAppointments()) : null,
                from.getDocuments() != null ? clientCaseDocumentDtoConverter.convert(from.getDocuments()) : null
        );
    }

    public List<ClientCaseDto> convert(List<ClientCase> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
