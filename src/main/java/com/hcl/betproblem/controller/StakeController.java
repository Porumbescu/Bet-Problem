package com.hcl.betproblem.controller;

import com.hcl.betproblem.service.StakeService;

public class StakeController {
    private final StakeService stakeService;

    public StakeController(StakeService stakeService) {
        this.stakeService = stakeService;
    }
}
