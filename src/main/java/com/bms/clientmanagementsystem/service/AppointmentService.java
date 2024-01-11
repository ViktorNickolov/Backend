package com.bms.clientmanagementsystem.service;

import com.bms.clientmanagementsystem.dto.AppointmentDto;
import com.bms.clientmanagementsystem.dto.converter.AppointmentDtoConverter;
import com.bms.clientmanagementsystem.exception.AppointmentNotFoundException;
import com.bms.clientmanagementsystem.helper.DateHelper;
import com.bms.clientmanagementsystem.helper.message.BusinessLogMessage;
import com.bms.clientmanagementsystem.helper.message.BusinessMessage;
import com.bms.clientmanagementsystem.model.Appointment;
import com.bms.clientmanagementsystem.repository.AppointmentRepository;
import com.bms.clientmanagementsystem.request.appointment.CreateAppointmentRequest;
import com.bms.clientmanagementsystem.request.appointment.UpdateAppointmentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final StatusService statusService;
    private final ClientCaseService clientCaseService;
    private final AppointmentDtoConverter converter;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              StatusService statusService,
                              ClientCaseService clientCaseService,
                              AppointmentDtoConverter converter) {
        this.appointmentRepository = appointmentRepository;
        this.statusService = statusService;
        this.clientCaseService = clientCaseService;
        this.converter = converter;
    }

    public void createAppointment(final CreateAppointmentRequest request) {
        Appointment appointment = new Appointment();

        appointment.setCreatedTime(DateHelper.getCurrentDateTime());
        appointment.setStartTime(request.getStartTime());
        appointment.setEndTime(DateHelper.getEndTime(request.getStartTime()));
        appointment.setStatus(statusService.findStatusByStatusId(request.getStatusId()));
        appointment.setClientCase(clientCaseService.findPatientCaseByPatientCaseId(request.getClientCaseId()));

        appointmentRepository.save(appointment);
        log.info(BusinessLogMessage.Appointment.APPOINTMENT_CREATED);
    }

    public void updateAppointment(final String id, final UpdateAppointmentRequest request) {
        Appointment appointment = findAppointmentByAppointmentId(id);

        appointment.setStartTime(request.getStartTime());
        appointment.setEndTime(DateHelper.getEndTime(request.getStartTime()));
        appointment.setStatus(statusService.findStatusByStatusId(request.getStatusId()));
        appointment.setClientCase(clientCaseService.findPatientCaseByPatientCaseId(request.getClientCaseId()));

        appointmentRepository.save(appointment);
        log.info(BusinessLogMessage.Appointment.APPOINTMENT_UPDATED + id);
    }

    public void deleteAppointment(final String id) {
        appointmentRepository.delete(findAppointmentByAppointmentId(id));
        log.info(BusinessLogMessage.Appointment.APPOINTMENT_DELETED + id);
    }

    public AppointmentDto findAppointmentById(final String id) {
        Appointment appointment = findAppointmentByAppointmentId(id);

        log.info(BusinessLogMessage.Appointment.APPOINTMENT_FOUND + id);
        return converter.convert(appointment);
    }

    public List<AppointmentDto> findAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();

        if (appointments.isEmpty()) {
            log.error(BusinessLogMessage.Appointment.APPOINTMENT_LIST_EMPTY);
            throw new AppointmentNotFoundException(BusinessMessage.Appointment.APPOINTMENT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Appointment.APPOINTMENT_LIST_FOUND);
        return converter.convert(appointments);
    }

    protected Appointment findAppointmentByAppointmentId(final String id) {
        return appointmentRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Appointment.APPOINTMENT_NOT_FOUND + id);
            throw new AppointmentNotFoundException(BusinessMessage.Appointment.APPOINTMENT_NOT_FOUND);
        });
    }
}
