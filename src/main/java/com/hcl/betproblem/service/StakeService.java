package com.hcl.betproblem.service;

import com.hcl.betproblem.repository.StakeRepository;
import org.springframework.stereotype.Service;

@Service
public class StakeService {
    private final StakeRepository stakeRepository;
    public StakeService(StakeRepository stakeRepository) {
        this.stakeRepository = stakeRepository;
    }
}
