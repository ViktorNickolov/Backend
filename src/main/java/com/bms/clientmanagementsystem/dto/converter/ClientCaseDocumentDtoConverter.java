package com.bms.clientmanagementsystem.dto.converter;

import com.bms.clientmanagementsystem.dto.ClientCaseDocumentDto;
import com.bms.clientmanagementsystem.model.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientCaseDocumentDtoConverter {
    public ClientCaseDocumentDto convert(Document from) {
        return new ClientCaseDocumentDto(
                from.getId(),
                from.getDocumentInternalId(),
                from.getName(),
                from.getUrl(),
                from.getDetail(),
                from.getAppointment() != null ? from.getAppointment().getId() : null,
                from.getClient() != null ? from.getClient().getId() : null
        );
    }

    public List<ClientCaseDocumentDto> convert(List<Document> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
