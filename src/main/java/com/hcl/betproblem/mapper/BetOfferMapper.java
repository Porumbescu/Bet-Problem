package com.hcl.betproblem.mapper;

import com.hcl.betproblem.dto.BetOfferDTO;
import com.hcl.betproblem.entity.BetOffer;

public class BetOfferMapper {

    public static BetOfferDTO toDTO(BetOffer betOffer) {
        BetOfferDTO dto = new BetOfferDTO();
        dto.setBetOfferId(betOffer.getBetOfferId());
        dto.setDescription(betOffer.getDescription());
        dto.setReturnRate(betOffer.getReturnRate());
        return dto;
    }

    public static BetOffer toEntity(BetOfferDTO dto) {
        BetOffer betOffer = new BetOffer();
        betOffer.setBetOfferId(dto.getBetOfferId());
        betOffer.setDescription(dto.getDescription());
        betOffer.setReturnRate(dto.getReturnRate());
        return betOffer;
    }
}
