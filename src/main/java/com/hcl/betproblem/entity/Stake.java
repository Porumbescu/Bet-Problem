package com.hcl.betproblem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="stake")
public class Stake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stake_id")
    private Long stakeId;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private BetOffer betOffer;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Session session;
    @Column(name = "stake_amount")
    private Double stakeAmount;

    public Stake() {
    }

    public Stake(Long stakeId, BetOffer betOffer, Session session, Double stakeAmount) {
        this.stakeId = stakeId;
        this.betOffer = betOffer;
        this.session = session;
        this.stakeAmount = stakeAmount;
    }

    public Long getStakeId() {
        return stakeId;
    }

    public void setStakeId(Long stakeId) {
        this.stakeId = stakeId;
    }

    public BetOffer getBetOffer() {
        return betOffer;
    }

    public void setBetOffer(BetOffer betOffer) {
        this.betOffer = betOffer;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Double getStakeAmount() {
        return stakeAmount;
    }

    public void setStakeAmount(Double stakeAmount) {
        this.stakeAmount = stakeAmount;
    }
}
