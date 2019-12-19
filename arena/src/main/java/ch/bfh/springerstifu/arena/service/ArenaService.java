package ch.bfh.springerstifu.arena.service;

import ch.bfh.springerstifu.arena.model.Party;

public interface ArenaService {

	String battle(Party challangee, Party challanger);

}
