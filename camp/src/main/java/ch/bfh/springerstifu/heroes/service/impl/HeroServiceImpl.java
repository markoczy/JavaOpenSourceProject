package ch.bfh.springerstifu.heroes.service.impl;

import java.util.Random;

import ch.bfh.springerstifu.heroes.model.Hero;
import ch.bfh.springerstifu.heroes.service.HeroService;

public class HeroServiceImpl implements HeroService {
    private Random random = new Random(System.currentTimeMillis());

    @Override
    public Hero createHero(String name) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setHp(100);
        hero.setAtk(random.nextInt(100) + 1);
        hero.setDef(random.nextInt(100) + 1);
        return hero;
    }

}