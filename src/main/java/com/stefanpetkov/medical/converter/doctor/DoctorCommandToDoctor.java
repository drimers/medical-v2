package com.stefanpetkov.medical.converter.doctor;

import com.stefanpetkov.medical.commands.AppointmentCommand;
import com.stefanpetkov.medical.commands.DoctorCommand;
import com.stefanpetkov.medical.domain.*;
import com.stefanpetkov.medical.exception.NotFoundException;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class DoctorCommandToDoctor implements Converter<DoctorCommand, Doctor> {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public Doctor convert(DoctorCommand command) {
        log.info("Converting command to doctor = {}", command);
        validateCommand(command);

        Optional<Doctor> doctorOptional = Optional.empty();
        if (command.getDoctorId() != null) {
            doctorOptional = doctorRepository.findById(command.getDoctorId());
        }

        Doctor doctor;

        if (doctorOptional.isPresent()) {
            if (doctorOptional.isPresent()) {
                doctor = doctorOptional.get();
                doctor.setFirstName(command.getDoctorFirstName());
                doctor.setLastName(command.getDoctorLastName());
                doctor.setPhone(command.getDoctorPhone());
                return doctor;
            }
        }

        doctor = new Doctor();
        doctor.setFirstName(command.getDoctorFirstName());
        doctor.setLastName(command.getDoctorLastName());
        doctor.setPhone(command.getDoctorPhone());


        UserCredentials doctorCredentials = new UserCredentials();
        doctorCredentials.setEmail(command.getDoctorEmail());
        doctorCredentials.setPassword(command.getDoctorPassword());
        doctorCredentials.setRole(Role.DOCTOR);
        //validateCredentials(doctorCredentials);

        doctor.setCredentials(doctorCredentials);
        doctorCredentials.setBaseUser(doctor);





        log.info("Doctor converted = {}", doctor);
        return doctor;

    }

    private void validateCommand(DoctorCommand doctor) {
        String errorMsg = "";
        if (doctor == null) {
            errorMsg += "Command is NULL!";
            log.error(errorMsg);
            throw new RuntimeException(errorMsg);
        }
        //todo validate other fields too, create custom Exception class
    }


}
