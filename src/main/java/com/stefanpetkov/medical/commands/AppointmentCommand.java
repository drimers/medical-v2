package com.stefanpetkov.medical.commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AppointmentCommand implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long appointmentId;

    private Long doctorId;

    private Long patientId;

    private LocalDateTime dateTimeOfTheAppointment;

    private String firstName;

    private String lastName;

}
