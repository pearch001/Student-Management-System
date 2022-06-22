package com.SMS.SMSapi.services;

import com.SMS.SMSapi.utils.ConfirmationToken;

public interface ConfirmationServiceInt {
    void saveConfirmationToken(ConfirmationToken confirmationToken);
}
