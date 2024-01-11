package com.bms.clientmanagementsystem.repository;

import com.bms.clientmanagementsystem.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, String> {
}