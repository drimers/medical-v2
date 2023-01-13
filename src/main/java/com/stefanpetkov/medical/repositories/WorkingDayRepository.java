package com.stefanpetkov.medical.repositories;

import com.stefanpetkov.medical.domain.WorkingDayEntity;
import org.springframework.data.repository.CrudRepository;

public interface WorkingDayRepository extends CrudRepository<WorkingDayEntity, Long> {

}
