package com.bms.clientmanagementsystem.dto.converter;

import com.bms.clientmanagementsystem.dto.ClientDocumentDto;
import com.bms.clientmanagementsystem.model.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientDocumentDtoConverter {
    public ClientDocumentDto convert(Document from) {
        return new ClientDocumentDto(
                from.getId(),
                from.getName(),
                from.getUrl(),
                from.getDetail(),
                from.getClientCase() != null ? from.getClientCase().getId() : null
        );
    }

    public List<ClientDocumentDto> convert(List<Document> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
