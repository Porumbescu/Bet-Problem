package com.hcl.betproblem.service;

import com.hcl.betproblem.dto.StakeDTO;
import com.hcl.betproblem.repository.BetOfferRepository;
import com.hcl.betproblem.repository.SessionRepository;
import com.hcl.betproblem.repository.StakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StakeService {
    private final StakeRepository stakeRepository;
    private final BetOfferRepository betOfferRepository;
    private final SessionRepository sessionRepository;

    public StakeService(StakeRepository stakeRepository,
                        BetOfferRepository betOfferRepository,
                        SessionRepository sessionRepository) {
        this.stakeRepository = stakeRepository;
        this.betOfferRepository = betOfferRepository;
        this.sessionRepository = sessionRepository;
    }

    public void postStake(StakeDTO stakeDTO) {
        // TODO: 12/14/2023
    }

    public List<StakeDTO> getHighStakes(Long betOfferId)  {
        // TODO: 12/14/2023
        return null;
    }
}
