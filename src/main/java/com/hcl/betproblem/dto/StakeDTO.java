package com.hcl.betproblem.dto;

public class StakeDTO {
    private Long betOfferId;
    private String sessionKey;
    private Double stakeAmount;

    public Long getBetOfferId () {
        return betOfferId;
    }

    public void setBetOfferId (Long betOfferId) {
        this.betOfferId = betOfferId;
    }

    public String getSessionKey () {
        return sessionKey;
    }

    public void setSessionKey (String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Double getStakeAmount () {
        return stakeAmount;
    }

    public void setStakeAmount (Double stakeAmount) {
        this.stakeAmount = stakeAmount;
    }
}
