package com.bms.clientmanagementsystem.helper;

import com.bms.clientmanagementsystem.helper.message.BusinessMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateHelper {
    private DateHelper() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public static LocalDateTime getEndTime(LocalDateTime startTime) {
        return startTime.plusMinutes(30);
    }
}
