package ch.bfh.springerstifu.camp.service.impl;

import java.util.Arrays;

// import org.springframework.beans.factory.annotation.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bfh.springerstifu.camp.model.Party;
import ch.bfh.springerstifu.camp.service.HeroService;
import ch.bfh.springerstifu.camp.service.PartyService;

@Service
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