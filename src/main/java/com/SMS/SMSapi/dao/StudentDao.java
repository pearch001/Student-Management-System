package com.SMS.SMSapi.dao;

import com.SMS.SMSapi.model.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentDao extends CrudRepository<Student,Long> {

    Optional<Student> findByEmail(String email);
}
