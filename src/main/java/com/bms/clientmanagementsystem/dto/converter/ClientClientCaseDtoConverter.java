package com.bms.clientmanagementsystem.dto.converter;

import com.bms.clientmanagementsystem.dto.ClientClientCaseDto;
import com.bms.clientmanagementsystem.model.ClientCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientClientCaseDtoConverter {
    public ClientClientCaseDto convert(ClientCase from) {
        return new ClientClientCaseDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getInProgress(),
                from.getTotalCost(),
                from.getAmountPaid()
        );
    }

    public List<ClientClientCaseDto> convert(List<ClientCase> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
