package com.hcl.betproblem.dto;

public class SessionDTO {
    private String sessionKey;
    private Integer customerId;

    public String getSessionKey () {
        return sessionKey;
    }

    public void setSessionKey (String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Integer getCustomerId () {
        return customerId;
    }

    public void setCustomerId (Integer customerId) {
        this.customerId = customerId;
    }
}
