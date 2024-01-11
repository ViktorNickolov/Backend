package com.bms.clientmanagementsystem.dto.converter;

import com.bms.clientmanagementsystem.dto.DocumentTypeDocumentDto;
import com.bms.clientmanagementsystem.model.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocumentTypeDocumentDtoConverter {
    public DocumentTypeDocumentDto convert(Document from) {
        return new DocumentTypeDocumentDto(
                from.getId(),
                from.getDocumentInternalId(),
                from.getName(),
                from.getUrl(),
                from.getDetail(),
                from.getAppointment() == null ? null : from.getAppointment().getId(),
                from.getClientCase() == null ? null : from.getClientCase().getId(),
                from.getClient() == null ? null : from.getClient().getId()
        );
    }

    public List<DocumentTypeDocumentDto> convert(List<Document> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
