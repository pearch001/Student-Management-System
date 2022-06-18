package com.SMS.SMSapi.dao;

import com.SMS.SMSapi.model.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student,Long> {
}
