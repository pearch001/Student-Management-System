package com.SMS.SMSapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ConfirmationToken extends CrudRepository<ConfirmationToken,Long> {

    Optional<ConfirmationToken> findByToken(String token);
}
