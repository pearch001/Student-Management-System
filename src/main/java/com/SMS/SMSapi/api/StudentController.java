package com.SMS.SMSapi.api;

import com.SMS.SMSapi.common.ApiResponse;
import com.SMS.SMSapi.common.EmailValidator;
import com.SMS.SMSapi.model.Dto.StudentDto;
import com.SMS.SMSapi.services.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RequestMapping("/api/v1/students")
@RestController
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;


    @PostMapping(value="/signup")
    public ResponseEntity<ApiResponse> signupUser(@RequestBody StudentDto studentDto){
        //Creating URI that would be passed into the response entity .created method
        log.info("hey");
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/users/signup/user").toUriString());

        studentService.saveStudent(studentDto);
        return new ResponseEntity<>(new ApiResponse(true,"Student registered"), HttpStatus.ACCEPTED);
    }
}
