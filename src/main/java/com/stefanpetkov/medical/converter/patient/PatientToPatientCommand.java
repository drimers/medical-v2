package com.stefanpetkov.medical.converter.patient;

import com.stefanpetkov.medical.commands.PatientCommand;
import com.stefanpetkov.medical.domain.PatientEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PatientToPatientCommand implements Converter<PatientEntity, PatientCommand> {


    @Override
    public PatientCommand convert(PatientEntity patientEntity) {
        return null;
    }


}
