package com.bms.clientmanagementsystem.repository;

import com.bms.clientmanagementsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}