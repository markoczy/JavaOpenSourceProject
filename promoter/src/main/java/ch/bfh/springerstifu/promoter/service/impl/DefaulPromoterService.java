package ch.bfh.springerstifu.promoter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bfh.springerstifu.promoter.client.ArenaClient;
import ch.bfh.springerstifu.promoter.client.CampClient;
import ch.bfh.springerstifu.promoter.model.Party;
import ch.bfh.springerstifu.promoter.service.PromoterService;

@Service
public class DefaulPromoterService implements PromoterService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaulPromoterService.class);

	@Autowired
	private CampClient campClient;

	@Autowired
	private ArenaClient arenaClient;

	@Override
	public String promoteFight() {

		Party challengee = campClient.createParty("Challengee").getContent();
		Party challenger = campClient.createParty("Challenger").getContent();
		LOG.info("Todays battle is between Party '" + challengee.getName() + "' and Party '" + challenger.getName()
				+ "'.");

		List<Party> challangers = new ArrayList<>();
		challangers.add(challengee);
		challangers.add(challenger);
		String winner = arenaClient.battle(challangers);
		LOG.info("And the winner is: Party '" + winner + "'");

		return winner;
	}
}
