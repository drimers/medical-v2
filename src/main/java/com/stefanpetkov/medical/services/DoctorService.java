package com.stefanpetkov.medical.services;


import com.stefanpetkov.medical.converter.doctor.DoctorCommandToDoctor;
import com.stefanpetkov.medical.converter.doctor.DoctorToDoctorCommand;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    private final DoctorToDoctorCommand toDoctorCommandConverter;
    private final DoctorCommandToDoctor toDoctorConverter;




//    public List<DoctorCommand> findAllDoctorsByPatientId(Long patientId) {
//        log.info("DoctorService:: findAllDoctorsByUserId");
//        List<DoctorEntity> entities = doctorRepository.findAllByPatientId(patientId);
//        List<DoctorCommand> commands = new ArrayList<>();
//        entities.forEach(entity -> {
//            DoctorCommand command = toDoctorCommandConverter.convert(entity);
//            commands.add(command);
//        });
//        return commands;
//    }

}
