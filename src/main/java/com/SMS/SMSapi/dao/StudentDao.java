package com.SMS.SMSapi.dao;

import com.SMS.SMSapi.model.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
public interface StudentDao extends CrudRepository<Student,Long> {

    Optional<Student> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE student s " +
            "SET s.enabled = TRUE WHERE s.email = ?1")
    void enableAppUser(String email);
}
