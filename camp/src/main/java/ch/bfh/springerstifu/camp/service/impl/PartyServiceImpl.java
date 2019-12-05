package ch.bfh.springerstifu.camp.service.impl;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.beans.factory.annotation.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bfh.springerstifu.camp.model.Hero;
import ch.bfh.springerstifu.camp.model.Party;
import ch.bfh.springerstifu.camp.service.HeroService;
import ch.bfh.springerstifu.camp.service.NameService;
import ch.bfh.springerstifu.camp.service.PartyService;

@Service
public class PartyServiceImpl implements PartyService {

    @Autowired
    private NameService nameService;

    @Autowired
    private HeroService heroService;

    @Override
    public Party createParty(String name) {
        Party party = new Party();
        party.setName(name);

        List<Hero> heroes = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heroes.add(heroService.createHero(nameService.getName()));
        }
        party.setMembers(heroes);

        return party;
    }

}