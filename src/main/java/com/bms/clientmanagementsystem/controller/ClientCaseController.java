package com.bms.clientmanagementsystem.controller;

import com.bms.clientmanagementsystem.dto.ClientCaseDto;
import com.bms.clientmanagementsystem.helper.message.ControllerLogMessage;
import com.bms.clientmanagementsystem.request.clientcase.CreateClientCaseRequest;
import com.bms.clientmanagementsystem.request.clientcase.UpdateClientCaseRequest;
import com.bms.clientmanagementsystem.service.ClientCaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientCases")
@Slf4j
public class ClientCaseController {
    private final ClientCaseService clientCaseService;

    public ClientCaseController(ClientCaseService clientCaseService) {
        this.clientCaseService = clientCaseService;
    }

    @PostMapping
    public ResponseEntity<Void> createClientCase(@RequestBody CreateClientCaseRequest request) {
        clientCaseService.createClientCase(request);

        log.info(ControllerLogMessage.PatientCase.PATIENT_CASE_CREATE);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClientCase(@PathVariable String id,
                                                  @RequestBody UpdateClientCaseRequest request) {
        clientCaseService.updateClientCase(id, request);

        log.info(ControllerLogMessage.PatientCase.PATIENT_CASE_UPDATE + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Void> completeClientCase(@PathVariable String id) {
        clientCaseService.completeClientCase(id);

        log.info(ControllerLogMessage.PatientCase.PATIENT_CASE_COMPLETE);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/pdf")
    public ResponseEntity<InputStreamResource> generatePdf(@PathVariable String id) {
        ByteArrayInputStream pdf = clientCaseService.createClientCaseDocument(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + id + ".pdf");

        log.info(ControllerLogMessage.PatientCase.PATIENT_CASE_PDF);
        return ResponseEntity.ok().headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientCaseDto> findClientCaseById(@PathVariable String id) {
        ClientCaseDto patientCase = clientCaseService.findClientCaseById(id);

        log.info(ControllerLogMessage.PatientCase.PATIENT_CASE_FIND + id);
        return ResponseEntity.ok(patientCase);
    }

    @GetMapping
    public ResponseEntity<List<ClientCaseDto>> findAllClientCases() {
        List<ClientCaseDto> patientCases = clientCaseService.findAllClientCases();

        log.info(ControllerLogMessage.PatientCase.PATIENT_CASE_FIND_ALL);
        return ResponseEntity.ok(patientCases);
    }
}
