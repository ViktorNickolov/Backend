package com.bms.clientmanagementsystem.service;

import com.bms.clientmanagementsystem.dto.DocumentDto;
import com.bms.clientmanagementsystem.dto.converter.DocumentDtoConverter;
import com.bms.clientmanagementsystem.exception.DocumentNotFoundException;
import com.bms.clientmanagementsystem.helper.DateHelper;
import com.bms.clientmanagementsystem.helper.Generator;
import com.bms.clientmanagementsystem.helper.message.BusinessLogMessage;
import com.bms.clientmanagementsystem.helper.message.BusinessMessage;
import com.bms.clientmanagementsystem.model.Document;
import com.bms.clientmanagementsystem.repository.DocumentRepository;
import com.bms.clientmanagementsystem.request.document.CreateDocumentRequest;
import com.bms.clientmanagementsystem.request.document.UpdateDocumentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
@Slf4j
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final PdfService pdfService;
    private final AppointmentService appointmentService;
    private final ClientCaseService clientCaseService;
    private final ClientService clientService;
    private final DocumentDtoConverter converter;

    public DocumentService(DocumentRepository documentRepository,
                           PdfService pdfService,
                           AppointmentService appointmentService,
                           ClientCaseService clientCaseService,
                           ClientService clientService,
                           DocumentDtoConverter converter) {
        this.documentRepository = documentRepository;
        this.pdfService = pdfService;
        this.appointmentService = appointmentService;
        this.clientCaseService = clientCaseService;
        this.clientService = clientService;
        this.converter = converter;
    }

    public void createDocument(final CreateDocumentRequest request) {
        Document document = new Document();

        document.setDocumentInternalId(Generator.generateDocumentInternalId());
        document.setName(request.getName());
        document.setCreatedTime(DateHelper.getCurrentDateTime());
        document.setDetail(request.getDetail());
        document.setAppointment(appointmentService.findAppointmentByAppointmentId(request.getAppointmentId()));
        document.setClientCase(clientCaseService.findPatientCaseByPatientCaseId(request.getClientId()));
        document.setClient(clientService.findClientByClientId(request.getClientId()));

        documentRepository.save(document);
        log.info(BusinessLogMessage.Document.DOCUMENT_CREATED);
    }

    public void updateDocument(final String id, final UpdateDocumentRequest request) {
        Document document = findDocumentByDocumentId(id);

        document.setName(request.getName());
        document.setDetail(request.getDetail());
        document.setUrl(Generator.generateUrl(document.getId()));
        document.setAppointment(appointmentService.findAppointmentByAppointmentId(request.getAppointmentId()));
        document.setClientCase(clientCaseService.findPatientCaseByPatientCaseId(request.getClientCaseId()));
        document.setClient(clientService.findClientByClientId(request.getClientId()));

        documentRepository.save(document);
        log.info(BusinessLogMessage.Document.DOCUMENT_UPDATED + id);
    }

    public ByteArrayInputStream createDocumentPdf(final String id) {
        log.info(BusinessLogMessage.Document.DOCUMENT_PDF_CREATED + id);
        return pdfService.generatePdf(findDocumentByDocumentId(id));
    }

    public void deleteDocument(final String id) {
        documentRepository.delete(findDocumentByDocumentId(id));
        log.info(BusinessLogMessage.Document.DOCUMENT_DELETED + id);
    }

    public DocumentDto findDocumentById(final String id) {
        Document document = findDocumentByDocumentId(id);

        log.info(BusinessLogMessage.Document.DOCUMENT_FOUND + id);
        return converter.convert(document);
    }

    public List<DocumentDto> findAllDocuments() {
        List<Document> documents = documentRepository.findAll();

        if (documents.isEmpty()) {
            log.info(BusinessLogMessage.Document.DOCUMENT_LIST_EMPTY);
            throw new DocumentNotFoundException(BusinessMessage.Document.DOCUMENT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Document.DOCUMENT_LIST_FOUND);
        return converter.convert(documents);
    }

    private Document findDocumentByDocumentId(final String id) {
        return documentRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Document.DOCUMENT_NOT_FOUND + id);
            return new RuntimeException(BusinessMessage.Document.DOCUMENT_NOT_FOUND);
        });
    }
}
