package ch.bfh.springerstifu.promoter.client.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ch.bfh.springerstifu.promoter.client.CampClient;
import ch.bfh.springerstifu.promoter.model.Party;

@Component
public class DefaultCampClient implements CampClient {

	@Override
	public EntityModel<Party> createParty(String name) {
		ResponseEntity<EntityModel<Party>> response = new RestTemplate().exchange(
				"http://localhost:2222/parties/createParty?name={name}", HttpMethod.GET, null,
				new ParameterizedTypeReference<EntityModel<Party>>() {
				}, name);
		return response.getBody();
	}

}
