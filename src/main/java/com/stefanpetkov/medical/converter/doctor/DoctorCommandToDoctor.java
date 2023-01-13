package com.stefanpetkov.medical.converter.doctor;

import com.stefanpetkov.medical.commands.DoctorCommand;
import com.stefanpetkov.medical.domain.DoctorEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DoctorCommandToDoctor implements Converter<DoctorCommand, DoctorEntity> {


    @Override
    public DoctorEntity convert(DoctorCommand source) {
        return null;
    }



}
