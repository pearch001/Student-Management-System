package com.SMS.SMSapi.services;

import com.SMS.SMSapi.dao.ConfirmationTokenDao;
import com.SMS.SMSapi.utils.ConfirmationToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor

@Transactional
@Slf4j
public class ConfirmationServiceImpl implements ConfirmationServiceInt{

    private final ConfirmationTokenDao confirmationTokenDao;
    @Override
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        confirmationTokenDao.save(confirmationToken);
    }
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenDao.findByToken(token);
    }
    public int setConfirmedAt(String token) {
        return confirmationTokenDao.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
