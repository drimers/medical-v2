package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.domain.Role;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import com.stefanpetkov.medical.services.AppointmentService;
import com.stefanpetkov.medical.services.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PatientController {


    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final CredentialsRepository credentialsRepository;

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;


    @RequestMapping("/patient")
    public String getDoctor(Model model) {// todo maybe place it in appointment controller and rename listAppointments or so
        log.info("PatientController::getDoctor()");

        model.addAttribute("doctors", appointmentRepository.findAppointmentEntitiesByPatient_IdEqualUserIdInDoctorsEntity(2L));
        // model.addAttribute("doctors", appointmentService.findAllDoctorsByPatientId(2L));
        //model.addAttribute("appointments", appointmentService.findAll());
        //model.addAttribute("appointments", appointmentService.findAppointmentEntitiesByDoctor_Id(1L));
        return "patient/patient";
    }


    // Form registration

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String register(@ModelAttribute("doctors") DoctorEntity doctor, @ModelAttribute("appointment") AppointmentEntity appointment, Model model) {
        System.out.println("get appointment:::" + appointment.getDateTimeOfTheAppointment());
        // doctorService.save(doctor);
        model.addAttribute("appointment", appointment);
        //appointmentService.saveOrUpdate(appointment);
        return "/patient/patient";
    }

//    @RequestMapping("/patient/{id}")
//    public String getDoctor(@PathVariable String id, Model model) {
//        model.addAttribute("doctor", doctorRepository.findAll());
//        model.addAttribute("appointment", appointmentRepository.findByAppointmentId(new Long(id)));
//
//        //  model.addAttribute("appointment", appointmentRepository.findAllByPatientId(9L));
//        // model.addAttribute("emailAccount", credentialsRepository.findByEmail("spp.bg@abv.bg"));
//
//        return "patient/patient";
//        // return "Greetings from Spring Boot Patients!";
//    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        PatientEntity patient = new PatientEntity();
        CredentialsEntity credentials = new CredentialsEntity();
//        List<String> role = new ArrayList<>();
//        role.add("Patient");
//        role.add("Doctor");
//        model.addAttribute("roles", role);
        model.addAttribute("patient", patient);
        model.addAttribute("credential", credentials);
        return "register";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String register(@ModelAttribute("patient") PatientEntity patient, @ModelAttribute("doctor") DoctorEntity doctor, @ModelAttribute("credential") CredentialsEntity credential, Model model) {
        System.out.println("get UserName:::" + patient.getFirstName());

//        model.addAttribute("patient", patient);
//        model.addAttribute("credential", credential);


        credential.setRole(Role.PATIENT);
        patient.setCredentials(credential);
        credential.setBaseUser(patient);
        patientRepository.save(patient);
        credentialsRepository.save(credential);
        log.info("Patient registration :: save()");
        return "display_form";

    }


    @RequestMapping(path = {"/search"})
    public String search(AppointmentEntity appointment, Model model, String keyword) {
        // List<AppointmentEntity> list = new ArrayList<>();
        if (keyword != null) {
            //List<AppointmentEntity> list = appointmentService.getByKeyword(keyword);
            model.addAttribute("doctors", appointmentService.getByKeyword(keyword));
        } else {
            List<AppointmentEntity> list = appointmentRepository.findAppointmentEntitiesByPatient_IdEqualUserIdInDoctorsEntity(2L);
            model.addAttribute("appointment", list);
        }
        return "patient/patient";
    }





}



