package com.vasheprime.lashmanager.repository;

import com.vasheprime.lashmanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByFirstNameContainingIgnoreCase(String clientName);

    List<Client> findByLastNameContainingIgnoreCase(String clientName);
}
