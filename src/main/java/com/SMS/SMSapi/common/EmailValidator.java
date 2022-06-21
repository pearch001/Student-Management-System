package com.SMS.SMSapi.common;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        if (s== null || s.isEmpty()){
            return false;
        }
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(pattern.matcher(s).matches()){
            return true;
        }else {
            return false;
        }
    }
}
