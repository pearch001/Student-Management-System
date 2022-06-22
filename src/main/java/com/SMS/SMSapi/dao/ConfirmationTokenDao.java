package com.SMS.SMSapi.dao;

import com.SMS.SMSapi.utils.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ConfirmationTokenDao extends CrudRepository<ConfirmationToken,Long> {

    Optional<ConfirmationTokenDao> findByToken(String token);
}
