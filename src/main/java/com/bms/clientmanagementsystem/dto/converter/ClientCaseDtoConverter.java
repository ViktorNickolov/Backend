package com.bms.clientmanagementsystem.dto.converter;

import com.bms.clientmanagementsystem.dto.ClientCaseDto;
import com.bms.clientmanagementsystem.model.ClientCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientCaseDtoConverter {
    private final ClientCaseDocumentDtoConverter clientCaseDocumentDtoConverter;

    public ClientCaseDtoConverter(ClientCaseDocumentDtoConverter clientCaseDocumentDtoConverter) {
        this.clientCaseDocumentDtoConverter = clientCaseDocumentDtoConverter;
    }

    public ClientCaseDto convert(ClientCase from) {
        return new ClientCaseDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getInProgress()
        );
    }

    public List<ClientCaseDto> convert(List<ClientCase> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
