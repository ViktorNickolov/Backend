package com.bms.clinicmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PatientDto {
    String id;
    String firstName;
    String lastName;
    List<PatientPatientCaseDto> patientCases;
    List<PatientDocumentDto> documents;
}
