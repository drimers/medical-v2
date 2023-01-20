package com.stefanpetkov.medical.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@Table(name = "working_day")
public class WorkingDayEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workingDayId;

    @Column(length = 50, nullable = false)
    private String workingDay;

    @Column(length = 50, nullable = false)
    private String startTime;

    @Column(length = 50, nullable = false)
    private String endTime;

    @ManyToOne
    private Doctor doctor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkingDayEntity that = (WorkingDayEntity) o;

        return Objects.equals(workingDayId, that.workingDayId);
    }

    @Override
    public int hashCode() {
        return workingDayId != null ? workingDayId.hashCode() + 7 : 31;
    }
}
