package com.stefanpetkov.medical.commands;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class DoctorCommand {

    //doctor
    private Long doctorId;
    private String doctorFirstName;
    private String doctorLastName;
    private String doctorPhone;
    private String doctorEmail;
    private String doctorPassword;
    //patient
    private Long patientId;
    private String patientFirstName;
    private String patientLastName;
    private String patientPhone;
    private String patientComment;

    //appointment
    private Long appointmentId;
    private LocalDateTime dateTimeOfTheAppointment;


}
