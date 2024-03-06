package com.bms.clientmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClientDto {
    String id;
    String firstName;
    String lastName;
    List<ClientClientCaseDto> ClientCases;
    List<ClientDocumentDto> documents;
}
