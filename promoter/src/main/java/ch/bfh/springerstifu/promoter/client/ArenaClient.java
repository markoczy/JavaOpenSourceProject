package ch.bfh.springerstifu.promoter.client;

import java.util.List;

import ch.bfh.springerstifu.promoter.model.Party;

public interface ArenaClient {
	String battle(List<Party> challenger);

}
