package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.services.AppointmentService;
import com.stefanpetkov.medical.services.DoctorService;
import com.stefanpetkov.medical.util.ApplicationConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Slf4j
@Controller
@RequiredArgsConstructor
public class DoctorController {


    private final DoctorService doctorService;
    private final AppointmentService appointmentService;
    private final AppointmentRepository appointmentRepository;


    @RequestMapping(ApplicationConstants.REQUEST_MAPPING_DOCTOR)
    public String getAllDoctors(Model model) {
        log.info("DoctorController::getPatient");
        List<PatientEntity> doctorCommands = appointmentService.findAllPatientsByDoctorId(1L);

        //List<AppointmentEntity> doctorCommands = appointmentService.findAll();
        //List<AppointmentEntity> appointmentEntities = appointmentService.findAppointmentEntitiesByPatient_Id(2L);
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAppointmentEntitiesByPatient_IdEqualUserIdInPatientEntity(1L);
        model.addAttribute("patients", doctorCommands);
        model.addAttribute("appointments", appointmentEntities);

        return ApplicationConstants.VIEW_NAME_DOCTORS;
    }


}
