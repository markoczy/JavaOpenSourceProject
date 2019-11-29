package ch.bfh.springerstifu.heroes;

import ch.bfh.springerstifu.heroes.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HeroesApplicationRunner implements ApplicationRunner {

    @Autowired
    private PartyService partyService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        partyService.createParty("Party_Numbero_Uno");
    }
}
