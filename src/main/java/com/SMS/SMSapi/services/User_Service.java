package com.SMS.SMSapi.services;

import com.SMS.SMSapi.model.JwtRequest;
import com.SMS.SMSapi.model.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface User_Service {

    User saveUser(User user);
    UserDetails loadUserByUsername(String username);
    void login(JwtRequest request) throws Exception;

}
