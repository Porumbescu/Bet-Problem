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
import java.util.List;

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

    public List<StakeDTO> getHighStakes(Long betOfferId)  {
        // TODO: 12/14/2023
        return null;
    }
}
