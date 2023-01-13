package com.stefanpetkov.medical.controllers;


import com.stefanpetkov.medical.commands.AppointmentCommand;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.services.AppointmentService;
import com.stefanpetkov.medical.services.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;


    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @RequestMapping(path = "/addAppointment")
    public String addAppointment(@ModelAttribute("appointment") AppointmentCommand appointment, Model model) {
        log.info("AppointmentController::addAppointment, command = {}", appointment);




       model.addAttribute("appointment", appointment);
        //appointmentService.save(appointment);
       // throw new RuntimeException("NOT IMPLEMENTED");
        return "appointment";
    }


    @RequestMapping(value = "/saveAppointment", method = RequestMethod.POST)
    public String saveAppointment(@ModelAttribute("appointment") AppointmentCommand appointment) {
        log.info("AppointmentController :: updateAppointment  appointment = {} ", appointment);
        appointmentService.save(appointment);// not ready
        return "redirect:/patient";
    }

    @GetMapping(path = "updateAppointmentForm")
    public String updateAppointmentForm(Model model, @RequestParam Long appointment_id) {
        log.info("AppointmentController::updateAppointmentForm appointment ID = {}", appointment_id);
        AppointmentCommand appointment = appointmentService.findById(appointment_id);
        log.info("Retrieved command = {}", appointment);
        model.addAttribute("appointment", appointment);
        return "editAppointment";
    }


    @RequestMapping(value = "/updateAppointment", method = RequestMethod.POST)
    public String updateAppointment(@ModelAttribute("appointment") AppointmentCommand appointment) {
        log.info("AppointmentController :: updateAppointment  appointment = {} ", appointment);
        appointmentService.update(appointment);
        return "redirect:/patient";
    }


    @GetMapping("/deleteAppointment")
    public String deleteAppointment(@RequestParam Long appointment_id) {
        log.info("AppointmentController::deleteAppointment appointment ID = {}", appointment_id);
        appointmentService.deleteById(appointment_id);
        return "redirect:/patient";
    }




}
