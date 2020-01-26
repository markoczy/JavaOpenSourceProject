package ch.bfh.springerstifu.promoter.client;

import java.util.List;

import org.springframework.stereotype.Component;

import ch.bfh.springerstifu.promoter.model.Party;

@Component
public class ArenaClientFallback implements ArenaClient {
    @Override
    public String battle(List<Party> challengers) {
        throw new RuntimeException("Fallbacks are overrated, good ol' 500 is the stuff :-)");
    }
}