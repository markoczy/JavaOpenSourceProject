package ch.bfh.springerstifu.camp.service;

import org.springframework.stereotype.Service;

import ch.bfh.springerstifu.camp.model.Party;

@Service
public interface PartyService {

    Party createParty(String name);
}
