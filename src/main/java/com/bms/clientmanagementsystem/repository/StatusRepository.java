package com.bms.clientmanagementsystem.repository;

import com.bms.clientmanagementsystem.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, String> {
    boolean existsByNameIgnoreCase(String name);
}