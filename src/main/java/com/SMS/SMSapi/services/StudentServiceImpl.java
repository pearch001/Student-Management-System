package com.SMS.SMSapi.services;

import com.SMS.SMSapi.dao.StudentDao;
import com.SMS.SMSapi.model.entities.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentServiceImpl implements UserDetailsService, StudentServiceInt {
    private final StudentDao studentDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Student> student = studentDao.findByEmail(s);
        return studentDao.findByEmail(s).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
    }
}
