package ch.bfh.springerstifu.heroes.service;

import org.springframework.stereotype.Service;

import ch.bfh.springerstifu.heroes.model.Hero;

@Service
public interface HeroService {

    Hero createHero(String name);
}
