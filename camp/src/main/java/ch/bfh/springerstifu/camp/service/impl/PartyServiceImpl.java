package ch.bfh.springerstifu.camp.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bfh.springerstifu.camp.model.Hero;
import ch.bfh.springerstifu.camp.model.Party;
import ch.bfh.springerstifu.camp.repository.HeroRepository;
import ch.bfh.springerstifu.camp.service.PartyService;

@Service
public class PartyServiceImpl implements PartyService {

	private List<Party> parties = new ArrayList<>();

	@Autowired
	private HeroRepository heroRepository;

	@Override
	public Party createParty(String name) {
		Party party = new Party();
		party.setName(name);

		List<Hero> heroes = new ArrayList<Hero>();
		heroRepository.findAll().forEach(heroes::add);
		Collections.shuffle(heroes);

		List<Hero> members = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			members.add(heroes.remove(0));
		}
		party.setMembers(members);
		parties.add(party);

		return party;
	}

	@Override
	public List<Party> getParties() {
		return Collections.unmodifiableList(parties);
	}

}