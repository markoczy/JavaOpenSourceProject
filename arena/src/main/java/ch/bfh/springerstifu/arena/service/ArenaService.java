package ch.bfh.springerstifu.arena.service;

import java.util.List;

import ch.bfh.springerstifu.arena.model.Party;

public interface ArenaService {

	List<Party> battle(Party challangee, Party challanger);

}
