package com.hcl.betproblem.controller;

import com.hcl.betproblem.dto.StakeDTO;
import com.hcl.betproblem.dto.StakeRequestBody;
import com.hcl.betproblem.entity.Session;
import com.hcl.betproblem.repository.SessionRepository;
import com.hcl.betproblem.service.SessionService;
import com.hcl.betproblem.service.StakeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StakeController {
    private final StakeService stakeService;
    private final SessionService sessionService;

    private final SessionRepository sessionRepository;

    private static final Logger logger = LoggerFactory.getLogger(StakeController.class);


    public StakeController(StakeService stakeService, SessionService sessionService, SessionRepository sessionRepository) {
        this.stakeService = stakeService;
        this.sessionService = sessionService;
        this.sessionRepository = sessionRepository;
    }

    @PostMapping("/{betOfferId}/stake")
    public ResponseEntity<?> postStake(@PathVariable Long betOfferId,
                                       @RequestParam String sessionKey,
                                       @RequestBody StakeRequestBody stakeAmount) {

        logger.info("Received stake post request: betOfferId={}, sessionKey={}, stakeAmount={}", betOfferId, sessionKey, stakeAmount);
        Session session = sessionRepository.findBySessionKey(sessionKey);

        if (!sessionService.isValidSession(session)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid session key");
        }

        StakeDTO stakeDTO = new StakeDTO();
        stakeDTO.setBetOfferId(betOfferId);
        stakeDTO.setSessionKey(sessionKey);
        stakeDTO.setStakeAmount(stakeAmount.getStakeAmount());

        stakeService.postStake(stakeDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{betOfferId}/highstakes")
    public ResponseEntity<String> getHighStakes(@PathVariable Long betOfferId) {
        String highStakesDTOs = stakeService.getHighStakes(betOfferId);
        return ResponseEntity.ok(highStakesDTOs);
    }
}
