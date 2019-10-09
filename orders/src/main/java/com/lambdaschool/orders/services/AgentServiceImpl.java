package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Agent;
import com.lambdaschool.orders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepository agentrepos;

    @Override
    public List<Agent> findAll() {
        List<Agent> rtnList = new ArrayList<>();
        agentrepos.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public Agent findById(long id) {
        return null;
    }

    @Override
    public Agent save(Agent agent) {
        return null;
    }

    @Override
    public Agent update(Agent agent) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
