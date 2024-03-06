package com.bms.clientmanagementsystem.helper;

import com.bms.clientmanagementsystem.helper.message.BusinessMessage;

import java.util.Random;

public class Generator {
    private Generator() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    private static final String URL = "http://localhost:8080/api/v1/documents/";

    public static String generateUrl(final String id) {
        return URL + id.toLowerCase().replace(" ", "-") + "/pdf";
    }
}
