package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.commands.PatientCommand;
import com.stefanpetkov.medical.services.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@Controller
public class PatientController {

    private final PatientService patientService;


    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String registerNewPatient(@ModelAttribute("patient") PatientCommand patientCommand, Model model) {
        log.info("PatientController::registerNewPatient patient command = {}", patientCommand);
        PatientCommand savedCommand = patientService.saveNewPatient(patientCommand);
        model.addAttribute("patient", savedCommand);
        return "display_form";
    }


    @GetMapping(path = "/patientEditForm")
    public String editPatient(Model model, @RequestParam Long patient_id) {
        log.info("PatientService::patientEditForm patient ID = {}", patient_id);
        PatientCommand patientCommand = patientService.findById(patient_id);
        log.info("Retrieved command = {}", patient_id);
        model.addAttribute("patient", patientCommand);
        return "patientEditForm";
    }

    @GetMapping(path = "/deletePatientAccount")
    public String deletePatient(Model model, @RequestParam Long patient_id) {
        log.info("PatientService::deletePatientAccount patient ID = {}", patient_id);
        patientService.deletePatientAccount(patient_id);
        return "redirect:/home";
    }



}



