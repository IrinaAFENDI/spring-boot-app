package com.vasheprime.lashmanager.controller;

import com.vasheprime.lashmanager.dto.ClientDTO;
import com.vasheprime.lashmanager.model.Client;
import com.vasheprime.lashmanager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/clients")

public class ClientRestController {

    @Autowired
    private ClientRepository clientRepository;

    //GET получить всех клиентов
    @GetMapping
    public List<ClientDTO> getAllClients() {
        return

                clientRepository.findAll()
                        .stream()
                        .map(this::convertToDTO
                        )
                        .collect(Collectors.toList());
            }
 // получить одного клипента
    @GetMapping("/{id}")
    public  ResponseEntity<ClientDTO>getClientById(@PathVariable Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        if(client == null) {
            return ResponseEntity.notFound().build();
        }
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setNotes(client.getNotes());
        return ResponseEntity.ok(dto);
    }

    //POST создать нового клиента
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        Client client = new Client();
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setNotes(clientDTO.getNotes());

        Client savedClient = clientRepository.save(client);

        ClientDTO result = new ClientDTO();

        result.setId(savedClient.getId());
        result.setFirstName(savedClient.getFirstName());
        result.setLastName(savedClient.getLastName());
        result.setPhoneNumber(savedClient.getPhoneNumber());
        result.setNotes(savedClient.getNotes());
        return result;

    }

    //обновить существующего клиепнта

    @PutMapping("/{id}")

    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        Client existingClient = clientRepository.findById(id).orElse(null);

        if(existingClient == null) {
            return ResponseEntity.notFound().build();
        }
        existingClient.setFirstName(clientDTO.getFirstName());
        existingClient.setLastName(clientDTO.getLastName());
        existingClient.setPhoneNumber(clientDTO.getPhoneNumber());
        existingClient.setNotes(clientDTO.getNotes());
        Client updatedClient = clientRepository.save(existingClient);

        ClientDTO result = new ClientDTO();
        result.setId(updatedClient.getId());
        result.setFirstName(updatedClient.getFirstName());
        result.setLastName(updatedClient.getLastName());
        result.setPhoneNumber(updatedClient.getPhoneNumber());
        result.setNotes(updatedClient.getNotes());

        return ResponseEntity.ok(result);
    }

    //удалить клиента

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        if(client == null) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    private ClientDTO convertToDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setNotes(client.getNotes());
        return dto;
    }

}
