package com.bms.clientmanagementsystem.repository;

import com.bms.clientmanagementsystem.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
}