package com.bms.clientmanagementsystem.controller;

import com.bms.clientmanagementsystem.dto.ClientDto;
import com.bms.clientmanagementsystem.helper.message.ControllerLogMessage;
import com.bms.clientmanagementsystem.request.client.CreateClientRequest;
import com.bms.clientmanagementsystem.request.client.UpdateClientRequest;
import com.bms.clientmanagementsystem.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Void> createClient(@RequestBody CreateClientRequest request) {
        clientService.createClient(request);

        log.info(ControllerLogMessage.Client.Client_CREATE);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable String id, @RequestBody UpdateClientRequest request) {
        clientService.updateClient(id, request);

        log.info(ControllerLogMessage.Client.Client_UPDATE + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);

        log.info(ControllerLogMessage.Client.Client_DELETE + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findClientById(@PathVariable String id) {
        ClientDto client = clientService.findClientById(id);

        log.info(ControllerLogMessage.Client.Client_FIND + id);
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAllClients() {
        List<ClientDto> Clients = clientService.findAllClients();

        log.info(ControllerLogMessage.Client.Client_FIND_ALL);
        return ResponseEntity.ok(Clients);
    }
}
