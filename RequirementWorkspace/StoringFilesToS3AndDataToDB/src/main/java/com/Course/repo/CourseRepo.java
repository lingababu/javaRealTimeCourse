package com.Course.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Course.entity.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long>{

}
