package com.machi.tech.customer_service.Repository;

import com.machi.tech.customer_service.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<String, Client> {
}
