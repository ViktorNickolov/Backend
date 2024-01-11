package com.bms.clientmanagementsystem.dto.converter;

import com.bms.clientmanagementsystem.dto.StatusStatusHistoryDto;
import com.bms.clientmanagementsystem.model.StatusHistory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusStatusHistoryDtoConverter {
    public StatusStatusHistoryDto convert(StatusHistory from) {
        return new StatusStatusHistoryDto(
                from.getId(),
                from.getTime(),
                from.getDescription(),
                from.getAppointment() != null ? from.getAppointment().getId() : null
        );
    }

    public List<StatusStatusHistoryDto> convert(List<StatusHistory> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
