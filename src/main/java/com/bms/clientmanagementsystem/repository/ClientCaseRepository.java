package com.bms.clientmanagementsystem.repository;

import com.bms.clientmanagementsystem.model.ClientCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientCaseRepository extends JpaRepository<ClientCase, String> {
}