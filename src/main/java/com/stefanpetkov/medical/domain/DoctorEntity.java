package com.stefanpetkov.medical.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "doctor")
public class DoctorEntity extends BaseUser implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Set<WorkingDayEntity> workingDay = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Set<AppointmentEntity> appointments = new HashSet<>();

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public void addAnAppointment(AppointmentEntity appointment) {
        this.appointments.add(appointment);
    }

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "doctorId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", workingDay=" + workingDay +
                ", credentials='" + credentials +
                '}';
    }

}
