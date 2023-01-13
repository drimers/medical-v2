package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.AppointmentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findAppointmentEntitiesByPatient_Id(Long patientId);

    List<AppointmentEntity> findAppointmentEntitiesByDoctor_Id(Long doctorId);


    //  public List<AppointmentEntity> findAppointmentEntitiesByPatient_IdEqualUserIdInDoctorsEntity(Long patientID) {
    @Query(value = "select * from APPOINTMENT as A join doctor as D on A.doctor_id=D.user_id  where A.patient_id= :patient_id", nativeQuery = true)
    List<AppointmentEntity> findAppointmentEntitiesByPatient_IdEqualUserIdInDoctorsEntity(Long patient_id);


    //select  *  from APPOINTMENT as A join PATIENT as P on A.patient_id=P.user_id  where A.doctor_id=1;
    @Query(value = "select  *  from APPOINTMENT as A join PATIENT as P on A.patient_id=P.user_id  where A.doctor_id= :doctor_id", nativeQuery = true)
    List<AppointmentEntity> findAppointmentEntitiesByPatient_IdEqualUserIdInPatientEntity(Long doctor_id);


    //Custom query
    // "select * from shop s where s.owner_name like %:keyword% or s.shop_type like %:keyword%"
    //select  *  from APPOINTMENT as A join PATIENT as P on A.patient_id=P.user_id  where P.first_name like  %:keyword% or A.date_time_of_the_appointment like  %:keyword%


    //select  *  from APPOINTMENT as A join Doctor as D on A.doctor_id=D.user_id  where D.first_name like  'Ivan'   or   A.date_time_of_the_appointment like '% :keyword %';
    //select  *  from APPOINTMENT as A join Doctor as D on A.doctor_id=D.user_id  where D.first_name='Ivan'
    @Query(value = "select  *  from APPOINTMENT as A join Doctor as D on A.doctor_id=D.user_id  where D.first_name like  CONCAT('%', :keyword, '%')  or   A.date_time_of_the_appointment like CONCAT('%', :keyword, '%');", nativeQuery = true)
    List<AppointmentEntity> findByKeyword(@Param("keyword") String keyword);

}
