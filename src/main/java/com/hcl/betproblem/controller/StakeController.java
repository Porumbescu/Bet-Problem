package com.hcl.betproblem.controller;

import com.hcl.betproblem.dto.StakeDTO;
import com.hcl.betproblem.service.SessionService;
import com.hcl.betproblem.service.StakeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StakeController {
    private final StakeService stakeService;
    private final SessionService sessionService;

    public StakeController(StakeService stakeService, SessionService sessionService) {
        this.stakeService = stakeService;
        this.sessionService = sessionService;
    }

    @PostMapping("/{betOfferId}/stake")
    public ResponseEntity<?> postStake(@PathVariable Long betOfferId,
                                       @RequestParam String sessionKey,
                                       @RequestBody Double stakeAmount) {
        if (!sessionService.isValidSession(sessionKey)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid session key");
        }

        StakeDTO stakeDTO = new StakeDTO();
        stakeDTO.setBetOfferId(betOfferId);
        stakeDTO.setSessionKey(sessionKey);
        stakeDTO.setStakeAmount(stakeAmount);

        stakeService.postStake(stakeDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{betOfferId}/highstakes")
    public ResponseEntity<List<StakeDTO>> getHighStakes(@PathVariable Long betOfferId) {
        List<StakeDTO> highStakesDTOs = stakeService.getHighStakes(betOfferId);
        return ResponseEntity.ok(highStakesDTOs);
    }
}
