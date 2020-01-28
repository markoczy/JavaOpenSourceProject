package ch.bfh.springerstifu.promoter.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.bfh.springerstifu.promoter.model.Party;

@FeignClient(value = "camp-service")
public interface CampClient {

	@GetMapping("/createParty")
	EntityModel<Party> createParty(@RequestParam(value = "name") String name);

}
