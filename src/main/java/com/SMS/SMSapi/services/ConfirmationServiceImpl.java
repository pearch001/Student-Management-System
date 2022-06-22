package com.SMS.SMSapi.services;

import com.SMS.SMSapi.dao.ConfirmationTokenDao;
import com.SMS.SMSapi.utils.ConfirmationToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ConfirmationServiceImpl implements ConfirmationServiceInt{
    @Autowired
    private ConfirmationTokenDao confirmationTokenDao;
    @Override
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        confirmationTokenDao.save(confirmationToken);
    }
}
