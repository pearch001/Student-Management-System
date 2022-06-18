package com.SMS.SMSapi.dao;

import com.SMS.SMSapi.model.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseDao extends CrudRepository<Course,Long> {
}
