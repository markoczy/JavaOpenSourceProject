package ch.bfh.springerstifu.arena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.bfh.springerstifu.arena.model.Party;
import ch.bfh.springerstifu.arena.service.ArenaService;

@RestController
@RequestMapping("/arena")
public class ArenaController {

	@Autowired
	private ArenaService arenaService;

	@PostMapping(value = "/battle")
	public String battle(@RequestBody List<Party> challengers) {
		if (challengers.size() != 2) {
			throw new RuntimeException("An error occured while battleing, challenger size is not 2");
		}

		Party challengee = challengers.get(0);
		Party challenger = challengers.get(1);
		Party winner = arenaService.battle(challengee, challenger);
		return "<h2>After a bloody fight between " + challengee.getName() + " and " + challenger.getName()
				+ " the winner is...(Trommelwirbel) \n</h2>" + winner;
	}

}
