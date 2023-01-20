package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.commands.PatientCommand;
import com.stefanpetkov.medical.domain.Appointment;
import com.stefanpetkov.medical.domain.Doctor;
import com.stefanpetkov.medical.domain.UserCredentials;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CredentialsController {


    private final AppointmentService appointmentService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("credentials", new UserCredentials());
        return "login";
    }


    // Form registration
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient", new PatientCommand());
        return "register";
    }

    @RequestMapping(value = "/logon", method = RequestMethod.POST)
    public String login(@ModelAttribute("credential") UserCredentials credentials,
                        @ModelAttribute("credential") Appointment appointment,
                        Model model) {
        model.addAttribute("appointments", appointmentService.appointmentsForPatient(2L) );
        // TODO: not implemented spring security
        return "patient/patientAppointments";
    }

}

