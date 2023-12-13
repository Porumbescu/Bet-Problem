package com.hcl.betproblem.repository;

import com.hcl.betproblem.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query("select * from session where customer_id = :customerId orderBy ")
    List<Session> findAllByCustomerId(@Param("customerId")final Integer customerId);
}
