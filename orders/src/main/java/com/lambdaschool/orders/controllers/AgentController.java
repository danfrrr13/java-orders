package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {
    @Autowired
    private AgentService agentService;

    //GET localhost:2019/agents/agents
    @GetMapping(value = "/agents", produces = {"application/json"})
    public ResponseEntity<?> listAllAgents() {
        List<Agent> myList = agentService.findAll();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}
