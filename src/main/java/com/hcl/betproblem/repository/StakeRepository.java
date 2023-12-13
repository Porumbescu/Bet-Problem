package com.hcl.betproblem.repository;

import com.hcl.betproblem.entity.Stake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StakeRepository extends JpaRepository<Stake, Long> {
}
