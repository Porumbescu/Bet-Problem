package com.hcl.betproblem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="bet_offer")
public class BetOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bet_offer_id")
    private Long betOfferId;
    @Column(name="description")
    private String description;
    @Column(name="return_rate")
    private Double returnRate;

    public BetOffer() {
    }

    public BetOffer(Long betOfferId, String description, Double returnRate) {
        this.betOfferId = betOfferId;
        this.description = description;
        this.returnRate = returnRate;
    }

    public Long getBetOfferId() {
        return betOfferId;
    }

    public void setBetOfferId(Long betOfferId) {
        this.betOfferId = betOfferId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(Double returnRate) {
        this.returnRate = returnRate;
    }
}

