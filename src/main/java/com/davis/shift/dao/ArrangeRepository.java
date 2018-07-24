package com.davis.shift.dao;

import com.davis.shift.entity.Arrange;
import com.davis.shift.entity.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ArrangeRepository extends JpaRepository<Arrange,String> {

    List<Arrange> findByDtBetweenAndUserIdEquals(LocalDate start, LocalDate end,String userId);
}
