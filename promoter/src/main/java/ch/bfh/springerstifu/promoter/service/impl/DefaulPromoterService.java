package ch.bfh.springerstifu.promoter.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
	private Random random = new Random();
	private static ArrayList<String> partyNames = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("FooFighters");
			add("Blue Crusaders");
			add("Ordinary Dust");
			add("Rotten Headhunters");
			add("Vendetta of the Angelic");
			add("Yell from the Mountains");
			add("Courage of the Serpent");
			add("Goldenmantles");
			add("Grayscars");
		}

	};

	@Autowired
	private CampClient campClient;

	@Autowired
	private ArenaClient arenaClient;

	@Override
	public List<Party> promoteFight() {

		int random1 = random.nextInt(4);
		int random2 = random.nextInt(5);
		Party challengee = campClient.createParty(partyNames.subList(0, 4).get(random1)).getContent();
		Party challenger = campClient.createParty(partyNames.subList(4, 9).get(random2)).getContent();
		LOG.info("Todays battle is between Party '" + challengee.getName() + "' and Party '" + challenger.getName()
				+ "'.");

		List<Party> battleParties = arenaClient.battle(Arrays.asList(challengee, challenger));

		return battleParties;
	}
}
