package ch.bfh.springerstifu.camp;

import ch.bfh.springerstifu.camp.repository.HeroRepository;
import ch.bfh.springerstifu.camp.service.HeroService;
import ch.bfh.springerstifu.camp.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CampApplicationRunner implements ApplicationRunner {
    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private NameService nameService;

    @Autowired
    private HeroService heroService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Count before insert:" + heroRepository.count());
        for (int i = 0; i < 10; i++) {
            String name = nameService.getName();
            System.out.println("Creating Hero with name: " + name);
            heroService.createHero(name);
        }
        System.out.println("Count after insert:" + heroRepository.count());
    }
}
