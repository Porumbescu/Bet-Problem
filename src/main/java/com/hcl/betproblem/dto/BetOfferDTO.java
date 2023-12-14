package com.hcl.betproblem.dto;

public class BetOfferDTO {
    private Long betOfferId;
    private String description;
    private Double returnRate;

    public Long getBetOfferId () {
        return betOfferId;
    }

    public void setBetOfferId (Long betOfferId) {
        this.betOfferId = betOfferId;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Double getReturnRate () {
        return returnRate;
    }

    public void setReturnRate (Double returnRate) {
        this.returnRate = returnRate;
    }
}
