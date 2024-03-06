package com.bms.clientmanagementsystem.service;

import com.bms.clientmanagementsystem.dto.ClientCaseDto;
import com.bms.clientmanagementsystem.dto.converter.ClientCaseDtoConverter;
import com.bms.clientmanagementsystem.exception.ClientCaseNotFoundException;
import com.bms.clientmanagementsystem.helper.DateHelper;
import com.bms.clientmanagementsystem.helper.message.BusinessLogMessage;
import com.bms.clientmanagementsystem.helper.message.BusinessMessage;
import com.bms.clientmanagementsystem.model.ClientCase;
import com.bms.clientmanagementsystem.repository.ClientCaseRepository;
import com.bms.clientmanagementsystem.request.clientcase.CreateClientCaseRequest;
import com.bms.clientmanagementsystem.request.clientcase.UpdateClientCaseRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
@Slf4j
public class ClientCaseService {
    private final ClientCaseRepository clientCaseRepository;
    private final ClientService clientService;
    private final PdfService pdfService;
    private final ClientCaseDtoConverter converter;

    public ClientCaseService(ClientCaseRepository clientCaseRepository,
                             ClientService clientService,
                             PdfService pdfService, ClientCaseDtoConverter converter) {
        this.clientCaseRepository = clientCaseRepository;
        this.clientService = clientService;
        this.pdfService = pdfService;
        this.converter = converter;
    }

    public void createClientCase(final CreateClientCaseRequest request) {
        ClientCase clientCase = new ClientCase();

        clientCase.setStartTime(DateHelper.getCurrentDateTime());
        clientCase.setClient(clientService.findClientByClientId(request.getClientId()));
        clientCase.setInProgress(true);

        clientCaseRepository.save(clientCase);
        log.info(BusinessLogMessage.ClientCase.Client_CASE_CREATED);
    }

    public void updateClientCase(final String id, final UpdateClientCaseRequest request) {
        ClientCase clientCase = findClientCaseByClientCaseId(id);

        clientCase.setClient(clientService.findClientByClientId(request.getClientId()));

        clientCaseRepository.save(clientCase);
        log.info(BusinessLogMessage.ClientCase.Client_CASE_UPDATED + id);
    }

    public void completeClientCase(final String id) {
        ClientCase clientCase = findClientCaseByClientCaseId(id);

        clientCase.setEndTime(DateHelper.getCurrentDateTime());
        clientCase.setInProgress(false);
        clientCaseRepository.save(clientCase);
        log.info(BusinessLogMessage.ClientCase.Client_CASE_COMPLETED + id);
    }

    public ByteArrayInputStream createClientCaseDocument(final String id) {
        log.info(BusinessLogMessage.ClientCase.Client_CASE_DOCUMENT_CREATED);
        return pdfService.generatePdf(findClientCaseByClientCaseId(id));
    }

    public ClientCaseDto findClientCaseById(final String id) {
        ClientCase clientCase = findClientCaseByClientCaseId(id);

        log.info(BusinessLogMessage.ClientCase.Client_CASE_FOUND + id);
        return converter.convert(clientCase);
    }

    public List<ClientCaseDto> findAllClientCases() {
        List<ClientCase> clientCases = clientCaseRepository.findAll();

        if (clientCases.isEmpty()) {
            log.info(BusinessLogMessage.ClientCase.Client_CASE_LIST_EMPTY);
            throw new ClientCaseNotFoundException(BusinessMessage.ClientCase.Client_CASE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.ClientCase.Client_CASE_LIST_FOUND);
        return converter.convert(clientCases);
    }

    protected ClientCase findClientCaseByClientCaseId(final String id) {
        return clientCaseRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.ClientCase.Client_CASE_NOT_FOUND + id);
            throw new ClientCaseNotFoundException(BusinessMessage.ClientCase.Client_CASE_NOT_FOUND);
        });
    }
}
