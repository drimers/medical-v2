package com.stefanpetkov.medical.converter.doctor;

import com.stefanpetkov.medical.commands.AppointmentCommand;
import com.stefanpetkov.medical.commands.DoctorCommand;
import com.stefanpetkov.medical.commands.PatientCommand;
import com.stefanpetkov.medical.domain.Appointment;
import com.stefanpetkov.medical.domain.Doctor;
import com.stefanpetkov.medical.domain.Patient;
import com.stefanpetkov.medical.domain.UserCredentials;
import com.stefanpetkov.medical.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
public class DoctorToDoctorCommand implements Converter<Doctor, DoctorCommand> {


    @Override
    public DoctorCommand convert(Doctor doctor) {
        log.info("Converting Doctor to command = {}", doctor);

        validateDoctor(doctor);


        Set<Appointment> appointment = doctor.getAppointments();
        Patient patient = new Patient();





        DoctorCommand command = new DoctorCommand();
        command.setDoctorId(doctor.getId());
        command.setDoctorFirstName(doctor.getFirstName());
        command.setDoctorLastName(doctor.getLastName());
        command.setDoctorPhone(doctor.getPhone());


        command.setPatientId(patient.getId());
        command.setPatientFirstName(patient.getFirstName());
        command.setPatientLastName(patient.getLastName());
        command.setPatientPhone(patient.getPhone());
        command.setPatientComment(patient.getComment());

        UserCredentials doctorCredentials = doctor.getCredentials();
        command.setDoctorEmail(doctorCredentials.getEmail());


        log.info("Command converted = {}", command);

        return command;

    }

    public void validateDoctor(Doctor doctor) {
        String errorMessage = "";
        if (doctor == null) {
            errorMessage = "Patient not found";
            log.error(errorMessage);
            throw new NotFoundException(errorMessage);
        }
    }
}