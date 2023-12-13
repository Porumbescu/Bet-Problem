package com.hcl.betproblem.repository;

import com.hcl.betproblem.entity.BetOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BetOfferRepository extends JpaRepository<BetOffer, Long> {
}
