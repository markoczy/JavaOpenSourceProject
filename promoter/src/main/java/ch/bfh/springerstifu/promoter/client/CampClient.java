package ch.bfh.springerstifu.promoter.client;

import org.springframework.hateoas.EntityModel;

import ch.bfh.springerstifu.promoter.model.Party;

public interface CampClient {

	EntityModel<Party> createParty(String name);

}
