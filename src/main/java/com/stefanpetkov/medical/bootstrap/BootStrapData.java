package com.stefanpetkov.medical.bootstrap;

import com.stefanpetkov.medical.domain.AppointmentEntity;
import com.stefanpetkov.medical.domain.CredentialsEntity;
import com.stefanpetkov.medical.domain.DoctorEntity;
import com.stefanpetkov.medical.domain.PatientEntity;
import com.stefanpetkov.medical.domain.Role;
import com.stefanpetkov.medical.repositories.AppointmentRepository;
import com.stefanpetkov.medical.repositories.CredentialsRepository;
import com.stefanpetkov.medical.repositories.DoctorRepository;
import com.stefanpetkov.medical.repositories.PatientRepository;
import com.stefanpetkov.medical.util.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Slf4j
@Component
public class BootStrapData implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final CredentialsRepository credentialsRepository;

    private final AppointmentRepository appointmentRepository;


    //Patients
    PatientEntity patient1 = new PatientEntity();
    PatientEntity patient2 = new PatientEntity();
    PatientEntity patient3 = new PatientEntity();


    //Doctors
    DoctorEntity doctor = new DoctorEntity();
    DoctorEntity doctor1 = new DoctorEntity();
    DoctorEntity doctor2 = new DoctorEntity();
    DoctorEntity doctor3 = new DoctorEntity();

    //Credentials
    CredentialsEntity credentials = new CredentialsEntity();
    CredentialsEntity credential = new CredentialsEntity();
    CredentialsEntity credentials1 = new CredentialsEntity();
    CredentialsEntity credentials2 = new CredentialsEntity();
    CredentialsEntity credentials3 = new CredentialsEntity();
    CredentialsEntity credentials4 = new CredentialsEntity();
    CredentialsEntity credentials5 = new CredentialsEntity();
    CredentialsEntity credentials6 = new CredentialsEntity();

    // Appointment
    AppointmentEntity appointment = new AppointmentEntity();
    AppointmentEntity appointment1 = new AppointmentEntity();
    AppointmentEntity appointment2 = new AppointmentEntity();
    AppointmentEntity appointment3 = new AppointmentEntity();





    public BootStrapData(DoctorRepository doctorRepository, PatientRepository patientRepository,
                         CredentialsRepository credentialsRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.credentialsRepository = credentialsRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Executing Bootstrap!");
        loadData();
        createPatients();
        createDoctors();
        createCredentials();
        makeAppointment();

        log.info("Bootstrap completed!");
    }

    PatientEntity patient = new PatientEntity();
    private void loadData() {

        // doctor
        doctor.setFirstName("Ivan");
        doctor.setLastName("Ivanov");
        doctor.setPhone("08987777777");
        log.info("Doctor created = {}", doctor);
        //doctorRepository.save(doctor);

        log.info("Doctors");
        log.info("Number of doctors = {}", doctorRepository.count());

        //Credential4

        credential.setEmail("doctor.bg@abv.bg");
        credential.setPassword("pass");
        credential.setRole(Role.DOCTOR);
        doctor.setCredentials(credential);
        credential.setBaseUser(doctor);
        doctorRepository.save(doctor);
        credentialsRepository.save(credential);

        ////////////////////////////////////////////////

        //patient
        patient.setFirstName("Stefan");
        patient.setLastName("Stefanov");
        patient.setPhone("0893343333");
        patient.setComment("Any comments!!!");
        log.info("Patient created = {}", patient);
        //patientRepository.save(patient);

        log.info("Patients");
        log.info("Number of patients = {}", patientRepository.count());


        // registration account
        credentials.setEmail("spp@abv.bg");
        credentials.setPassword("pass");
        credentials.setRole(Role.PATIENT);
        patient.setCredentials(credentials);
        credentials.setBaseUser(patient);
        patientRepository.save(patient);
        credentialsRepository.save(credentials);

        log.info("Credentials");
        log.info("Number of credential  = {}", credentialsRepository.count());


        // appointment
        LocalDateTime ldt = LocalDateTime.of(2023, 1, 9, 13, 5);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ApplicationConstants.DAY_MONTH_YEAR_HOUR_MINUTE_FORMATTER);
        log.info("Formatted date = {}", dtf.toString());
        appointment.setDateTimeOfTheAppointment(ldt);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        log.info("Appointment = {}", appointment);
        appointmentRepository.save(appointment);

        log.info("Appointments");
        log.info("Number of appointments = {}", appointmentRepository.count());
    }



    private void createPatients() {
        // patient1
        patient1.setFirstName("Jon");
        patient1.setLastName("Brown");
        patient1.setPhone("089333");
        patient1.setComment("Any comments!!!");
        log.info("Patient created = {}", patient1);
        //patientRepository.save(patient);



        // patient 2
        patient2.setFirstName("Goro");
        patient2.setLastName("Stoyanov");
        patient2.setPhone("63463563");
        patient2.setComment("Any comments!!!");
        log.info("Patient created = {}", patient2);

        // patient3
        patient3.setFirstName("Nikolai");
        patient3.setLastName("Petrov");
        patient3.setPhone("436354");
        patient3.setComment("Any comments!!!");
        log.info("Patient created = {}", patient3);

        log.info("Patients");
        log.info("Number of patients = {}", patientRepository.count());
    }


    private void createDoctors() {

        doctor1.setFirstName("Stefan");
        doctor1.setLastName("Ivanov");
        doctor1.setPhone("634653465");
        log.info("Doctor created = {}", doctor1);
 //       doctorRepository.save(doctor1);

        doctor2.setFirstName("Goro");
        doctor2.setLastName("Petkov");
        doctor2.setPhone("6534673432");
        log.info("Doctor created = {}", doctor2);
  //      doctorRepository.save(doctor2);

        doctor3.setFirstName("Jon");
        doctor3.setLastName("Dou");
        doctor3.setPhone("08987777777");
        log.info("Doctor created = {}", doctor3);
 //       doctorRepository.save(doctor3);




        log.info("Doctors");
        log.info("Number of doctors = {}", doctorRepository.count());



    }

    private void createCredentials() {
        //Patients
        //credential1
        credentials1.setEmail("patient1@abv.bg");
        credentials1.setPassword("pass");
        credentials1.setRole(Role.PATIENT);
        patient1.setCredentials(credentials1);
        credentials1.setBaseUser(patient1);
        patientRepository.save(patient1);
        credentialsRepository.save(credentials1);

        //credential2
        credentials2.setEmail("patient2@abv.bg");
        credentials2.setPassword("pass");
        credentials2.setRole(Role.PATIENT);
        patient2.setCredentials(credentials2);
        credentials2.setBaseUser(patient2);
        patientRepository.save(patient2);
        credentialsRepository.save(credentials2);

        //credential3
        credentials3.setEmail("patient3@abv.bg");
        credentials3.setPassword("pass");
        credentials3.setRole(Role.PATIENT);
        patient3.setCredentials(credentials3);
        credentials3.setBaseUser(patient3);
        patientRepository.save(patient3);
        credentialsRepository.save(credentials3);

        log.info("Credentials");
        log.info("Number of credential  = {}", credentialsRepository.count());

        //Credential4
        credentials4.setEmail("doctor1@abv.bg");
        credentials4.setPassword("pass");
        credentials4.setRole(Role.DOCTOR);
        doctor1.setCredentials(credentials4);
        credentials4.setBaseUser(doctor1);
        doctorRepository.save(doctor1);
        credentialsRepository.save(credentials4);

        //credential5
        credentials5.setEmail("doctor2@abv.bg");
        credentials5.setPassword("pass");
        credentials5.setRole(Role.DOCTOR);
        doctor2.setCredentials(credentials5);
        credentials5.setBaseUser(doctor2);
        doctorRepository.save(doctor2);
        credentialsRepository.save(credentials5);

        //credential6
        credentials6.setEmail("doctor3@abv.bg");
        credentials6.setPassword("pass");
        credentials6.setRole(Role.DOCTOR);
        doctor3.setCredentials(credentials6);
        credentials6.setBaseUser(doctor3);
        doctorRepository.save(doctor3);
        credentialsRepository.save(credentials6);

    }


    public void makeAppointment(){

        LocalDateTime ldt1 = LocalDateTime.of(2023, 2, 10, 13, 5);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(ApplicationConstants.DAY_MONTH_YEAR_HOUR_MINUTE_FORMATTER);
        log.info("Formatted date = {}", dtf1.toString());
        appointment1.setDateTimeOfTheAppointment(ldt1);
        appointment1.setPatient(patient);
        appointment1.setDoctor(doctor2);
        log.info("Appointment = {}", appointment1);
        appointmentRepository.save(appointment1);

        log.info("Appointments");
        log.info("Number of appointments = {}", appointmentRepository.count());


        LocalDateTime ldt2 = LocalDateTime.of(2023, 3, 11, 13, 5);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(ApplicationConstants.DAY_MONTH_YEAR_HOUR_MINUTE_FORMATTER);
        log.info("Formatted date = {}", dtf2.toString());
        appointment2.setDateTimeOfTheAppointment(ldt2);
        appointment2.setPatient(patient3);
        appointment2.setDoctor(doctor3);
        log.info("Appointment = {}", appointment2);
        appointmentRepository.save(appointment2);

        log.info("Appointments");
        log.info("Number of appointments = {}", appointmentRepository.count());


        LocalDateTime ldt3 = LocalDateTime.of(2024, 12, 11, 13, 5);
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern(ApplicationConstants.DAY_MONTH_YEAR_HOUR_MINUTE_FORMATTER);
        log.info("Formatted date = {}", dtf3.toString());
        appointment3.setDateTimeOfTheAppointment(ldt3);
        appointment3.setPatient(patient3);
        appointment3.setDoctor(doctor);
        log.info("Appointment = {}", appointment3);
        appointmentRepository.save(appointment3);

        log.info("Appointments");
        log.info("Number of appointments = {}", appointmentRepository.count());

    }

}
