package ch.bfh.springerstifu.arena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.bfh.springerstifu.arena.model.Party;
import ch.bfh.springerstifu.arena.service.ArenaService;

@RestController
public class ArenaController {

	@Autowired
	private ArenaService arenaService;

	@PostMapping(value = "/battle")
	public Party[] battle(@RequestBody List<Party> challengers) {
		if (challengers.size() != 2) {
			throw new RuntimeException("An error occured while battleing, challenger size is not 2");
		}

		Party challengee = challengers.get(0);
		Party challenger = challengers.get(1);
		List<Party> battleParties = arenaService.battle(challengee, challenger);

		return (Party[]) battleParties.toArray();
	}

}
