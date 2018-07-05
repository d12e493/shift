package com.davis.shift.dao;

import com.davis.shift.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends PagingAndSortingRepository<Category,String> {
}
