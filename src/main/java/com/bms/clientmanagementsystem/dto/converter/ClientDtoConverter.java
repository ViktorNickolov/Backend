package com.bms.clientmanagementsystem.dto.converter;

import com.bms.clientmanagementsystem.dto.ClientDto;
import com.bms.clientmanagementsystem.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientDtoConverter {
    private final ClientClientCaseDtoConverter ClientCaseDtoConverter;
    private final ClientDocumentDtoConverter documentDtoConverter;

    public ClientDtoConverter(ClientClientCaseDtoConverter ClientCaseDtoConverter,
                              ClientDocumentDtoConverter documentDtoConverter) {
        this.ClientCaseDtoConverter = ClientCaseDtoConverter;
        this.documentDtoConverter = documentDtoConverter;
    }

    public ClientDto convert(Client from) {
        return new ClientDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getClientCases() != null ? ClientCaseDtoConverter.convert(from.getClientCases()) : null,
                from.getDocuments() != null ? documentDtoConverter.convert(from.getDocuments()) : null
        );
    }

    public List<ClientDto> convert(List<Client> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
