package com.hcl.betproblem.controller;

import com.hcl.betproblem.service.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

//    @GetMapping(value = "/{customerId}/session")
//    public Integer getOrCreateSession(@PathVariable int customerId){
//        return sessionService.getOrCreate(customerId);
//    }
}
