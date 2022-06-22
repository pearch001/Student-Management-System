package com.SMS.SMSapi.services;

import com.SMS.SMSapi.common.EmailValidator;
import com.SMS.SMSapi.dao.StudentDao;
import com.SMS.SMSapi.exceptions.EmailNotValidException;
import com.SMS.SMSapi.exceptions.UserExistException;
import com.SMS.SMSapi.model.Dto.StudentDto;
import com.SMS.SMSapi.model.entities.AppUser;
import com.SMS.SMSapi.model.entities.Student;
import com.SMS.SMSapi.utils.ConfirmationToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentServiceImpl implements UserDetailsService, StudentServiceInt {

    private final StudentDao studentDao;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    EmailValidator emailValidator;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Student> student = studentDao.findByEmail(s);
        return studentDao.findByEmail(s).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
    }

    @Override
    public void saveStudent(StudentDto studentDto) {
        boolean isValidEmail = emailValidator.test(studentDto.getEmail());
        if (!isValidEmail){
            throw new EmailNotValidException("Email Provided is not valid");
        }
        Student student = new Student(studentDto.getFirstName(),studentDto.getLastName(),studentDto.getEmail(),
        studentDto.getPhone(),studentDto.getGender(),studentDto.getPassword(), AppUser.USER);
        boolean isStudentexit = studentDao.findByEmail(studentDto.getEmail()).isPresent();
        if(isStudentexit){
            throw new UserExistException("User Already Exists");
        }
        student.setPassword(bCryptPasswordEncoder.encode(studentDto.getPassword()));
        studentDao.save(student);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(30));

    }

}
