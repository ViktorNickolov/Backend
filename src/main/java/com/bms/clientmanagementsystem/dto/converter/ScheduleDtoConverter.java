package com.bms.clientmanagementsystem.dto.converter;

import com.bms.clientmanagementsystem.dto.ScheduleDto;
import com.bms.clientmanagementsystem.model.Schedule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleDtoConverter {
    public ScheduleDto convert(Schedule from) {
        return new ScheduleDto(
                from.getId(),
                from.getDate(),
                from.getStartTime(),
                from.getEndTime()
        );
    }

    public List<ScheduleDto> convert(List<Schedule> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
