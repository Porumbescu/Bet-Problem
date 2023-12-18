package com.hcl.betproblem.service;

import com.hcl.betproblem.dto.StakeDTO;
import com.hcl.betproblem.entity.BetOffer;
import com.hcl.betproblem.entity.Session;
import com.hcl.betproblem.entity.Stake;
import com.hcl.betproblem.exception.BetOfferNotFoundException;
import com.hcl.betproblem.exception.InvalidOrExpiredSessionException;
import com.hcl.betproblem.mapper.StakeMapper;
import com.hcl.betproblem.repository.BetOfferRepository;
import com.hcl.betproblem.repository.SessionRepository;
import com.hcl.betproblem.repository.StakeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StakeService {
    private static final Logger logger = LoggerFactory.getLogger(StakeService.class);

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
        logger.info("Attempting to post stake: {}", stakeDTO);

        Session session = sessionRepository.findBySessionKey(stakeDTO.getSessionKey());
        if (session == null || isSessionExpired(session)) {
            logger.warn("Session is invalid or expired for sessionKey: {}", stakeDTO.getSessionKey());
            throw new InvalidOrExpiredSessionException("Session is invalid or expired.");
        }

        BetOffer betOffer = betOfferRepository.findById(stakeDTO.getBetOfferId())
                .orElseThrow(() -> new BetOfferNotFoundException("Bet Offer not found"));
        logger.info("Bet offer found: {}", betOffer);

        Stake stake = StakeMapper.toEntity(stakeDTO, betOffer, session);
        stakeRepository.save(stake);
        logger.info("Stake saved successfully: {}", stake);
    }

    private boolean isSessionExpired(Session session) {
        LocalDateTime now = LocalDateTime.now();
        return ChronoUnit.MINUTES.between(session.getCreationDate(), now) >= 10;
    }

    public String getHighStakes(Long betOfferId)  {
        List<Stake> stakesList = stakeRepository.findTopStakes(betOfferId);
        HashMap<Integer, Double> top20 = new HashMap<Integer, Double>();
        int counter = 0;
        while (top20.size() < 20 && stakesList.size() > counter) {
            Stake stake = stakesList.get(counter);
            if (!top20.containsKey(stake.getSession().getCustomerId())) {
                top20.put(stakesList.get(counter).getSession().getCustomerId(), stake.getStakeAmount());
            }
            counter++;
        }
        return top20.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining(","));
    }
}
