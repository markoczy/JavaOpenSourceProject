package ch.bfh.springerstifu.heroes.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import ch.bfh.springerstifu.heroes.service.HeroService;
import ch.bfh.springerstifu.heroes.service.PartyService;
import ch.bfh.springerstifu.heroes.service.impl.HeroServiceImpl;
import ch.bfh.springerstifu.heroes.service.impl.PartyServiceImpl;

@Configuration
public class ServiceConfiguration {
    @Bean
    @Primary
    public HeroService heroService() {
        return new HeroServiceImpl();
    }

    @Bean
    @Primary
    public PartyService partyService() {
        return new PartyServiceImpl();
    }
}