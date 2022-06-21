package com.SMS.SMSapi.model.Dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    @Pattern(regexp= "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message= "Kindly provide a valid email address")
    @Column(unique = true)
    private String email;
    private String phone;
    private String gender;
    private String password;
}
