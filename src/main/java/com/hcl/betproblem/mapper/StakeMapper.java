package com.hcl.betproblem.mapper;

import com.hcl.betproblem.dto.StakeDTO;
import com.hcl.betproblem.entity.BetOffer;
import com.hcl.betproblem.entity.Session;
import com.hcl.betproblem.entity.Stake;

public class StakeMapper {

    public static StakeDTO toDTO(Stake stake) {
        StakeDTO dto = new StakeDTO();
        dto.setBetOfferId(stake.getBetOffer().getBetOfferId());
        dto.setSessionKey(stake.getSession().getSessionKey());
        dto.setStakeAmount(stake.getStakeAmount());
        return dto;
    }

    public static Stake toEntity(StakeDTO dto, BetOffer betOffer, Session session) {
        Stake stake = new Stake();
        stake.setBetOffer(betOffer);
        stake.setSession(session);
        stake.setStakeAmount(dto.getStakeAmount());
        return stake;
    }
}
