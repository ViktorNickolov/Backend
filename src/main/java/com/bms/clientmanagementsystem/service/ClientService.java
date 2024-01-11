package com.bms.clientmanagementsystem.service;

import com.bms.clientmanagementsystem.dto.ClientDto;
import com.bms.clientmanagementsystem.dto.converter.ClientDtoConverter;
import com.bms.clientmanagementsystem.exception.PatientAlreadyExistException;
import com.bms.clientmanagementsystem.exception.PatientNotFoundException;
import com.bms.clientmanagementsystem.helper.message.BusinessLogMessage;
import com.bms.clientmanagementsystem.helper.message.BusinessMessage;
import com.bms.clientmanagementsystem.model.Client;
import com.bms.clientmanagementsystem.repository.ClientRepository;
import com.bms.clientmanagementsystem.request.client.CreateClientRequest;
import com.bms.clientmanagementsystem.request.client.UpdateClientRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientDtoConverter converter;

    public ClientService(ClientRepository clientRepository,
                         ClientDtoConverter converter) {
        this.clientRepository = clientRepository;
        this.converter = converter;
    }

    public void createClient(final CreateClientRequest request) {
        Client client = new Client();

        checkIfClientExists(request.getFirstName(), request.getLastName());

        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());

        clientRepository.save(client);
        log.info(BusinessLogMessage.Patient.PATIENT_CREATED);
    }

    public void updateClient(final String id, UpdateClientRequest request) {
        Client client = findClientByClientId(id);

        if (!client.getFirstName().equals(request.getFirstName()) || !client.getLastName().equals(request.getLastName())) {
            checkIfClientExists(request.getFirstName(), request.getLastName());
        }

        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());

        clientRepository.save(client);
        log.info(BusinessLogMessage.Patient.PATIENT_UPDATED + id);
    }

    public void deleteClient(final String id) {
        clientRepository.delete(findClientByClientId(id));
        log.info(BusinessLogMessage.Patient.PATIENT_DELETED + id);
    }

    public ClientDto findClientById(final String id) {
        Client client = findClientByClientId(id);

        log.info(BusinessLogMessage.Patient.PATIENT_FOUND + id);
        return converter.convert(client);
    }

    public List<ClientDto> findAllClients() {
        List<Client> clients = clientRepository.findAll();

        if (clients.isEmpty()) {
            log.info(BusinessLogMessage.Patient.PATIENT_LIST_EMPTY);
            throw new PatientNotFoundException(BusinessMessage.Patient.PATIENT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Patient.PATIENT_LIST_FOUND);
        return converter.convert(clients);
    }

    protected Client findClientByClientId(final String id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.Patient.PATIENT_NOT_FOUND + id);
                    return new PatientAlreadyExistException(BusinessMessage.Patient.PATIENT_NOT_FOUND);
                });
    }

    private void checkIfClientExists(final String firstName, final String latName) {
        if (clientRepository.existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, latName)) {
            log.error(BusinessLogMessage.Patient.PATIENT_ALREADY_EXISTS + firstName + " " + latName);
            throw new PatientAlreadyExistException(BusinessMessage.Patient.PATIENT_ALREADY_EXISTS);
        }
    }
}
