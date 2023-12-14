package com.hcl.betproblem.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="session_id")
    private Integer sessionId;

    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "session_key")
    private String sessionKey;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public Session() {
    }

    public Session(Integer sessionId, Integer customerId, String sessionKey, LocalDateTime creationDate) {
        this.sessionId = sessionId;
        this.customerId = customerId;
        this.sessionKey = sessionKey;
        this.creationDate = creationDate;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
