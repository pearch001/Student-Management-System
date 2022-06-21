package com.SMS.SMSapi.exceptions;

public class UserExistException extends IllegalStateException{
    public UserExistException(String s) {
        super(s);
    }
}
