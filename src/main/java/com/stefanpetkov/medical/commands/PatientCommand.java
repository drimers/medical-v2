package com.stefanpetkov.medical.commands;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PatientCommand {

    private Long patientId;
    private String firstName;
    private String lastName;
    private String phone;
    private String comment;

    private String email;
    private String password;

}