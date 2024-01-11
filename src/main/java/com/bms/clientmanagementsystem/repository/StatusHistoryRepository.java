package com.bms.clientmanagementsystem.repository;

import com.bms.clientmanagementsystem.model.StatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusHistoryRepository extends JpaRepository<StatusHistory, String> {
}