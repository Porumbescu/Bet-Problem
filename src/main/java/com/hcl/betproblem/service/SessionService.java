package com.hcl.betproblem.service;

import com.hcl.betproblem.dto.SessionDTO;
import com.hcl.betproblem.entity.Session;
import com.hcl.betproblem.mapper.SessionMapper;
import com.hcl.betproblem.repository.SessionRepository;
import com.hcl.betproblem.util.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public SessionDTO getOrCreate(Integer customerId) {
        Session session;
        //the last available session for the given customerId
        List<Session> sessions = sessionRepository.findAllByCustomerId(customerId);
        session = sessions.isEmpty() ? null : sessions.get(0);

        LocalDateTime now = LocalDateTime.now();
        if (session != null) {
            long minutes = ChronoUnit.MINUTES.between(session.getCreationDate(), now);
            if (minutes < 10) {
                return SessionMapper.toDTO(session);
            }
        }

        Session newSession = new Session();
        newSession.setCustomerId(customerId);
        newSession.setCreationDate(now);
        newSession.setSessionKey(RandomStringGenerator.generateRandomString());
        sessionRepository.save(newSession);

        return SessionMapper.toDTO(newSession);
    }

    public boolean isValidSession (String sessionKey) {
        // TODO: 12/14/2023
        // custom exceptions?
        return false;
    }
}
