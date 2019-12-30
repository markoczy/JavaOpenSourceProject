package ch.bfh.springerstifu.promoter.client.impl;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ch.bfh.springerstifu.promoter.client.ArenaClient;
import ch.bfh.springerstifu.promoter.model.Party;

@Component
public class DefaultArenaClient implements ArenaClient {

	@Override
	public String battle(List<Party> challengers) {
		ResponseEntity<String> response = new RestTemplate().exchange("http://localhost:3333/arena/battle",
				HttpMethod.POST, new HttpEntity<>(challengers), String.class);
		return response.getBody();
	}

}
