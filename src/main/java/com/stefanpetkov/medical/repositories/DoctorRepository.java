package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.DoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<DoctorEntity, Long> {


    DoctorEntity findAllById(Long ID);

    //@Query("from DoctorEntity doctor where doctor.id in (select a.doctor.id from AppointmentEntity a where a.patient.id =: patientId)")
    //@Query(nativeQuery = true, name = "select * from DOCTOR where USER_ID  in (select DOCTOR_ID from APPOINTMENT where PATIENT_ID =: patientId);")
    //List<DoctorEntity> findAllByPatientId(@Param("patientId") Long patientId);


}
