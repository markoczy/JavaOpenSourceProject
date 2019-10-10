package ch.bfh.springerstifu.heroes.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import ch.bfh.springerstifu.heroes.model.Party;
import ch.bfh.springerstifu.heroes.service.HeroService;
import ch.bfh.springerstifu.heroes.service.PartyService;

public class PartyServiceImpl implements PartyService {
    @Autowired
    private HeroService heroService;

    @Override
    public Party createParty(String name) {
        Party party = new Party();
        party.setName(name);

        party.setMembers(Arrays.asList(
                //
                heroService.createHero("Ark"),
                //
                heroService.createHero("Fyda"),
                //
                heroService.createHero("Royd"),
                //
                heroService.createHero("Elle")));

        return party;
    }

}