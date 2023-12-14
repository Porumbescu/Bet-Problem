package com.hcl.betproblem.service;

import com.hcl.betproblem.repository.StakeRepository;
import org.springframework.stereotype.Service;

@Service
public class StakeService {
    private final StakeRepository stakeRepository;
    public StakeService(StakeRepository stakeRepository) {
        this.stakeRepository = stakeRepository;
    }

    public void postStake (Long betOfferId, String sessionKey, Double stakeAmount) {
        // TODO: 12/14/2023
    }

    public String getHighStakes (Long betOfferId) {
        // TODO: 12/14/2023
        return null;
    }
}
