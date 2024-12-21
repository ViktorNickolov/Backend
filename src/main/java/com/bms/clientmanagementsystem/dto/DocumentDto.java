package com.bms.clientmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentDto {
    String id;
    String name;
    String url;
    String detail;
    String clientCaseId;
    String clientId;
}
