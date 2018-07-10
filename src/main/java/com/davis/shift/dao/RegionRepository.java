package com.davis.shift.dao;

import com.davis.shift.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,String> {
}
