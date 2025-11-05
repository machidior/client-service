package com.machi.tech.customer_service.Repository;

import com.machi.tech.customer_service.model.Client;
import com.machi.tech.customer_service.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByNidaNumber(String nidaNumber);
    List<Client> findByStatus(Status status);
    List<Client> findByLoanOfficerId(String loanOfficerId);
    Page<Client> findAll(Pageable pageable);
}
