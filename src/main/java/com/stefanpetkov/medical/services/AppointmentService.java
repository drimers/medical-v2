package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.commands.AppointmentCommand;
import com.stefanpetkov.medical.converter.appointment.AppointmentCommandToAppointment;
import com.stefanpetkov.medical.converter.appointment.AppointmentToAppointmentCommand;
import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentService {


    private final AppointmentRepository appointmentRepository;
    private final AppointmentToAppointmentCommand toAppointmentCommand;
    private final AppointmentCommandToAppointment toAppointment;

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;


    public List<AppointmentEntity> findAll() {
        Iterable<AppointmentEntity> all = appointmentRepository.findAll();
        List<AppointmentEntity> entities = new ArrayList<>();
        all.iterator().forEachRemaining(entities::add);
        return entities;
    }

    public List<DoctorEntity> findAllDoctorsByPatientId(Long patientId) {
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAppointmentEntitiesByPatient_Id(patientId);
        List<DoctorEntity> doctorEntities = new ArrayList<>();
        appointmentEntities.forEach(appointment -> {
            doctorEntities.add(appointment.getDoctor());
        });
        return doctorEntities;
    }


    public List<PatientEntity> findAllPatientsByDoctorId(Long doctorId) {
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAppointmentEntitiesByDoctor_Id(doctorId);
        List<PatientEntity> patientEntities = new ArrayList<>();
        appointmentEntities.forEach(appointment -> {
            patientEntities.add(appointment.getPatient());
        });
        return patientEntities;
    }

    public List<AppointmentEntity> findAppointmentEntitiesByDoctor_Id(Long doctorID) {
        //List<AppointmentEntity> appointmentEntities = appointmentRepository.findAllAppointmentByPatient_Id(patientId);
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAppointmentEntitiesByDoctor_Id(doctorID);
        List<AppointmentEntity> entities = new ArrayList<>();
        appointmentEntities.iterator().forEachRemaining(entities::add);
        return entities;
    }

    public List<AppointmentEntity> findAppointmentEntitiesByPatient_Id(Long patientID) {
        //List<AppointmentEntity> appointmentEntities = appointmentRepository.findAllAppointmentByPatient_Id(patientId);
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAppointmentEntitiesByPatient_Id(patientID);
        List<AppointmentEntity> entities = new ArrayList<>();
        appointmentEntities.iterator().forEachRemaining(entities::add);
        return entities;
    }


    public List<AppointmentEntity> getByKeyword(String keyword) {
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findByKeyword(keyword);
        List<AppointmentEntity> entities = new ArrayList<>();
        appointmentEntities.iterator().forEachRemaining(entities::add);
        return entities;
    }

    //=======================================================================================

    public void save(AppointmentCommand appointmentCommand) {
        log.info("AppointmentService::save saving command = {}", appointmentCommand);
        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setDoctor(doctorRepository.findAllById(appointmentCommand.getDoctorId()));
        appointment.setPatient(patientRepository.findAllById(appointmentCommand.getPatientId()));
        appointment.setDateTimeOfTheAppointment(appointmentCommand.getDateTimeOfTheAppointment());
        AppointmentEntity savedEntity = appointmentRepository.save(appointment);
        log.info("Saved command = {}", savedEntity);
    }


    public void update(AppointmentCommand appointmentCommand) {
        log.info("AppointmentService::update saving command = {}", appointmentCommand);
        validateCommand(appointmentCommand);
        AppointmentEntity appointment = appointmentRepository
                .findById(appointmentCommand.getAppointmentId())
                .orElseThrow(() -> new RuntimeException("Resource not found exception for ID=" + appointmentCommand.getAppointmentId()));

        appointment.setDateTimeOfTheAppointment(appointmentCommand.getDateTimeOfTheAppointment());
        AppointmentEntity savedEntity = appointmentRepository.save(appointment);
        log.info("Saved command = {}", savedEntity);
    }

    public AppointmentCommand findById(Long appointmentId) {
        log.info("AppointmentService::findById, id passed = {}", appointmentId);

        Optional<AppointmentEntity> appointmentOptional = appointmentRepository.findById(appointmentId);
        if (appointmentOptional.isEmpty()) {
            throw new RuntimeException("Appointment with ID=" + appointmentId + " not found");
        }
        AppointmentEntity appointment = appointmentOptional.get();
        log.info("AppointmentService::findById, id passed = {}, extracted appointment = {}", appointmentId, appointment);

        AppointmentCommand command = toAppointmentCommand.convert(appointment);

        log.info("AppointmentService::Converted command  = {}", command);

        return command;
    }


    public void deleteById(Long appointmentId) {
        log.info("AppointmentService::deleteById, id passed = {}", appointmentId);
        // retrieve to validate existence if needed
        appointmentRepository.deleteById(appointmentId);
        log.info("AppointmentService::deleteById, deleted");
    }

    private void validateCommand(AppointmentCommand command) {
        String errorMsg = "";
        if (command == null) {
            errorMsg += "Command is NULL!";
            log.error(errorMsg);
            throw new RuntimeException(errorMsg);
        }
        if (command.getAppointmentId() == null) {
            errorMsg += "Command ID is NULL!";
            log.error(errorMsg);
            throw new RuntimeException(errorMsg);
        }
        //todo validate other fields too, create custom Exception class
    }

}