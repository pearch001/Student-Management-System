package com.SMS.SMSapi.exceptions;


public class EmailNotValidException extends IllegalStateException{
    public EmailNotValidException(String s){
        super(s);
    }
}
