package ch.bfh.springerstifu.arena.service;

import ch.bfh.springerstifu.arena.model.Party;

public interface ArenaService {

	Party battle(Party challangee, Party challanger);

}
