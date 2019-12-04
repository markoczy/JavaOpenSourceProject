package ch.bfh.springerstifu.camp.service.impl;

import java.util.Random;

import ch.bfh.springerstifu.camp.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bfh.springerstifu.camp.model.Hero;
import ch.bfh.springerstifu.camp.service.HeroService;

@Service
public class HeroServiceImpl implements HeroService {
    private Random random = new Random(System.currentTimeMillis());

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Hero createHero(String name) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setHp(100);
        hero.setAtk(random.nextInt(100) + 1);
        hero.setDef(random.nextInt(100) + 1);

        // Persistence
        String id = heroRepository.save(hero).getId();
        return heroRepository.findById(id).get();
    }

}