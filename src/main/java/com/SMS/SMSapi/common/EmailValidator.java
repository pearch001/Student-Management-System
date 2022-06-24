package com.SMS.SMSapi.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Slf4j
@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        if (s == null || s.isEmpty()){
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        log.info(emailRegex);
        Pattern pattern = Pattern.compile(emailRegex);
        if(pattern.matcher(s).matches()){
            log.info(s);
            return true;
        }else {
            log.info(s + "false");
            return false;
        }
    }
}
