package ch.bfh.springerstifu.camp.service;

import org.springframework.stereotype.Service;

import ch.bfh.springerstifu.camp.model.Hero;

@Service
public interface HeroService {

    Hero createHero(String name);
}
