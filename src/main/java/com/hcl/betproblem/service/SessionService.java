package com.hcl.betproblem.service;

import com.hcl.betproblem.entity.Session;
import com.hcl.betproblem.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public String getOrCreate(Integer customerId) {
        Session session;
        //the last available session for the given customerId
        session = sessionRepository.findAllByCustomerId(customerId).get(0);
        LocalDateTime date = LocalDateTime.now();
        if (session != null) {
            long minutes = ChronoUnit.MINUTES.between(date, session.getCreationDate());
            if (minutes < 10) {
                return session.getSessionKey();
            } else {
                Session newSession = new Session();
                newSession.setCustomerId(customerId);
                newSession.setCreationDate(date);
                //TO DO: set session key
                sessionRepository.save(newSession);
                return newSession.getSessionKey();
            }
        } else {
            Session newSession = new Session();
            newSession.setCustomerId(customerId);
            newSession.setCreationDate(date);
            //TO DO: set session key
            sessionRepository.save(newSession);
            return newSession.getSessionKey();
        }
    }

    public boolean isValidSession (String sessionKey) {
        // TODO: 12/14/2023
        // custom exceptions?
        return false;
    }
}
