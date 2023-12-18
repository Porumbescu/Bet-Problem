package com.hcl.betproblem.repository;

import com.hcl.betproblem.dto.StakeDTO;
import com.hcl.betproblem.entity.Session;
import com.hcl.betproblem.entity.Stake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StakeRepository extends JpaRepository<Stake, Long> {
    @Query(nativeQuery = true, value = "select * from stake where bet_offer_bet_offer_id = :betOfferId order by stake_amount desc")
    List<Stake> findTopStakes(@Param("betOfferId")final Long betOfferId);
}
