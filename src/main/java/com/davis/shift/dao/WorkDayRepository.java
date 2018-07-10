package com.davis.shift.dao;

import com.davis.shift.entity.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WorkDayRepository extends JpaRepository<WorkDay,String> {
    List<WorkDay> findByDtBetween(LocalDate start,LocalDate end);
}
