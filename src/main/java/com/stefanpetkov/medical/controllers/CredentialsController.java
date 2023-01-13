package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CredentialsController {

    private final AppointmentService appointmentService;
    private final DoctorRepository doctorRepository;
    private final CredentialsRepository credentialsRepository;
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public CredentialsController(AppointmentService appointmentService, DoctorRepository doctorRepository, CredentialsRepository credentialsRepository, AppointmentRepository appointmentRepository) {
        this.appointmentService = appointmentService;
        this.doctorRepository = doctorRepository;
        this.credentialsRepository = credentialsRepository;
        this.appointmentRepository = appointmentRepository;
    }



    @GetMapping("/login")
    public String showLoginForm(Model model) {
        CredentialsEntity credentials = new CredentialsEntity();
        model.addAttribute("credential", credentials);
        return "login";
    }


    @RequestMapping(value = "/logon", method = RequestMethod.POST)
    public String login(@ModelAttribute("credential") CredentialsEntity credentials, @ModelAttribute("doctors") DoctorEntity doctor, @ModelAttribute("appointments") AppointmentEntity appointment, Model model) {
        System.out.println("get Email:::" + credentials.getEmail());

        model.addAttribute("doctors", appointmentRepository.findAppointmentEntitiesByPatient_IdEqualUserIdInDoctorsEntity(2L));

        CredentialsEntity username = credentialsRepository.findByEmail(credentials.getEmail());

        System.out.println("Email : " + credentials.getEmail());
        System.out.println("Email Password : " + credentials.getPassword());

        if (username != null) {
            System.out.println("username : " + username.getEmail());
            System.out.println("Password : " + username.getPassword());


            if ((username.getEmail().equals(credentials.getEmail())) && (username.getPassword().equals(credentials.getPassword()))) {
                System.out.println("redirect:patient");
                return "patient/patient";
            }
        }
        System.out.println("Username not valid");
        return "login";
    }


}

