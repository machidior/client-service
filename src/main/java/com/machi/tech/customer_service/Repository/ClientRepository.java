package com.machi.tech.customer_service.Repository;

import com.machi.tech.customer_service.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    boolean existsByNidaNumber(String nidaNumber);
    Optional<Client> findByNidaNumber(String nidaNumber);
}
