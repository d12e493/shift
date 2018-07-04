package com.davis.shift.dao;

import com.davis.shift.entity.Organize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrganizeRepository extends JpaRepository<Organize,String> {
}
