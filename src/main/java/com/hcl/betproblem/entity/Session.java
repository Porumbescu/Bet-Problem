package com.hcl.betproblem.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sessionId")
    private Integer sessionKey;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public Session() {
    }

    public Session(Integer customerId, Integer sessionKey, LocalDateTime creationDate) {
        this.customerId = customerId;
        this.sessionKey = sessionKey;
        this.creationDate = creationDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(Integer sessionKey) {
        this.sessionKey = sessionKey;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
