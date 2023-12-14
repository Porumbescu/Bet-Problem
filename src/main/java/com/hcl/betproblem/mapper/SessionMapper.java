package com.hcl.betproblem.mapper;

import com.hcl.betproblem.dto.SessionDTO;
import com.hcl.betproblem.entity.Session;

public class SessionMapper {

    public static SessionDTO toDTO(Session session) {
        SessionDTO dto = new SessionDTO();
        dto.setSessionKey(session.getSessionKey());
        dto.setCustomerId(session.getCustomerId());
        return dto;
    }

    public static Session toEntity(SessionDTO dto) {
        Session session = new Session();
        session.setSessionKey(dto.getSessionKey());
        session.setCustomerId(dto.getCustomerId());
        return session;
    }
}
