package ch.bfh.springerstifu.heroes.service;

import org.springframework.stereotype.Service;

import ch.bfh.springerstifu.heroes.model.Party;

@Service
public interface PartyService {

    Party createParty(String name);
}
