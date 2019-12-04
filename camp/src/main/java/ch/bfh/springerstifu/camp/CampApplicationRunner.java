package ch.bfh.springerstifu.camp;

import ch.bfh.springerstifu.camp.model.Party;
import ch.bfh.springerstifu.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ch.bfh.springerstifu.camp.model.Hero;

@Component
public class CampApplicationRunner implements ApplicationRunner {
    // @Autowired
    // private HeroRepository heroRepository;

    @Autowired
    private PartyService partyService;

    // @Autowired
    // private NameService nameService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Party party = partyService.createParty("Party_Numbero_Uno");

        for (Hero hero : party.getMembers()) {
            System.out.println(hero);
        }
    }
}
