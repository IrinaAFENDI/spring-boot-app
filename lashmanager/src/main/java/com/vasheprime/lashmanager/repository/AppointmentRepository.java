package com.vasheprime.lashmanager.repository;


import com.vasheprime.lashmanager.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByAppointmentDateBetween(LocalDateTime start, LocalDateTime end);

    List<Appointment> findByClientId(Long clientId);

}
