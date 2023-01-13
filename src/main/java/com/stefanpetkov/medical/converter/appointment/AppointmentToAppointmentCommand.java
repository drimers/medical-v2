package com.stefanpetkov.medical.converter.appointment;

import com.stefanpetkov.medical.commands.AppointmentCommand;
import com.stefanpetkov.medical.domain.AppointmentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppointmentToAppointmentCommand implements Converter<AppointmentEntity, AppointmentCommand> {


    @Override
    public AppointmentCommand convert(AppointmentEntity appointment) {

        if (appointment == null) {
            String errorMsg = "Passed appointment is NULL!";
            log.error(errorMsg);
            throw new RuntimeException(errorMsg);
        }

        log.info("AppointmentToAppointmentCommand::Converting {}", appointment);

        AppointmentCommand command = new AppointmentCommand();

        command.setAppointmentId(appointment.getAppointmentId());
        command.setDoctorId(appointment.getDoctor().getId());
        command.setPatientId(appointment.getPatient().getId());
        command.setDateTimeOfTheAppointment(appointment.getDateTimeOfTheAppointment());
        command.setFirstName(appointment.getDoctor().getFirstName());
        command.setLastName(appointment.getDoctor().getLastName());

        log.info("AppointmentToAppointmentCommand::Command constructed {}", command);

        return command;
    }


}
