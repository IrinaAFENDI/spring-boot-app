package com.vasheprime.lashmanager.controller;

import com.vasheprime.lashmanager.dto.AppointmentDTO;
import com.vasheprime.lashmanager.model.Appointment;
import com.vasheprime.lashmanager.model.Client;
import com.vasheprime.lashmanager.repository.AppointmentRepository;
import com.vasheprime.lashmanager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {


        return

                appointmentRepository.findAll()
                        .stream()
                        .map(this::convertToDTO)
                        .collect(Collectors.toList());


    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentDTO createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Client client = clientRepository.findById(appointmentDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found: " + appointmentDTO.getClientId()));

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setClientVolume(appointmentDTO.getClientVolume());
        appointment.setClientEffect(appointmentDTO.getClientEffect());
        appointment.setMasterCurl(appointmentDTO.getMasterCurl());
        appointment.setMasterLength(appointmentDTO.getMasterLength());
        appointment.setMasterNotes(appointmentDTO.getMasterNotes());
        appointment.setClient(client);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return convertToDTO(savedAppointment);  // ← вместо ручного копирования
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        if (!appointmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        appointmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDTO(appointment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
        Appointment existingAppointment = appointmentRepository.findById(id).orElse(null);
        if (existingAppointment == null) {
            return ResponseEntity.notFound().build();
        }


        Client client = clientRepository.findById(appointmentDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));


        existingAppointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        existingAppointment.setClientVolume(appointmentDTO.getClientVolume());
        existingAppointment.setClientEffect(appointmentDTO.getClientEffect());
        existingAppointment.setMasterCurl(appointmentDTO.getMasterCurl());
        existingAppointment.setMasterLength(appointmentDTO.getMasterLength());
        existingAppointment.setMasterNotes(appointmentDTO.getMasterNotes());
        existingAppointment.setClient(client);

        Appointment savedAppointment = appointmentRepository.save(existingAppointment);
        return ResponseEntity.ok(convertToDTO(savedAppointment));
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setClientVolume(appointment.getClientVolume());
        dto.setClientEffect(appointment.getClientEffect());
        dto.setMasterCurl(appointment.getMasterCurl());
        dto.setMasterLength(appointment.getMasterLength());
        dto.setMasterNotes(appointment.getMasterNotes());
        dto.setClientId(appointment.getClient().getId());
        return dto;
    }

}
