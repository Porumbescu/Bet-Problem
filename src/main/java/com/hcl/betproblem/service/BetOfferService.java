package com.hcl.betproblem.service;

import com.hcl.betproblem.repository.BetOfferRepository;
import org.springframework.stereotype.Service;

@Service
public class BetOfferService {
    private final BetOfferRepository betOfferRepository;
    public BetOfferService(BetOfferRepository betOfferRepository) {
        this.betOfferRepository = betOfferRepository;
    }
}
