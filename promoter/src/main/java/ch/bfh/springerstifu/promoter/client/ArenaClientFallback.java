package ch.bfh.springerstifu.promoter.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ch.bfh.springerstifu.promoter.model.Party;

@Component
public class ArenaClientFallback implements ArenaClient {
	@Override
	public List<Party> battle(List<Party> challengers) {
		return new ArrayList<>();
	}
}