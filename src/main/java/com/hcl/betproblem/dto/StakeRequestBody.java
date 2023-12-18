package com.hcl.betproblem.dto;

public class StakeRequestBody extends StakeDTO{

    private Double stakeAmount;

    public StakeRequestBody() {
    }

    public Double getStakeAmount() {
        return stakeAmount;
    }

    public void setStakeAmount(Double stakeAmount) {
        this.stakeAmount = stakeAmount;
    }
}
