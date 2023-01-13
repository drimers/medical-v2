package com.stefanpetkov.medical.converter.appointment;

import com.stefanpetkov.medical.commands.AppointmentCommand;
import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AppointmentCommandToAppointment implements Converter<AppointmentCommand, AppointmentEntity> {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public AppointmentEntity convert(AppointmentCommand command) {
        if (command == null) {
            String errorMsg = "Passed command is NULL!";
            log.error(errorMsg);
            throw new RuntimeException(errorMsg);
        }

        log.info("Converting command = {}", command);
        DoctorEntity doctor = doctorRepository.findById(command.getDoctorId()).orElseThrow(() -> new RuntimeException("doctor null"));
        PatientEntity patient = patientRepository.findById(command.getPatientId()).orElseThrow(() -> new RuntimeException("patient null"));

        AppointmentEntity entity = new AppointmentEntity();
        entity.setAppointmentId(command.getAppointmentId());
        entity.setDoctor(doctor);
        entity.setPatient(patient);
        entity.setDateTimeOfTheAppointment(command.getDateTimeOfTheAppointment());

        return entity;
    }
}
