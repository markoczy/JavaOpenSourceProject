package ch.bfh.springerstifu.promoter.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ch.bfh.springerstifu.promoter.client.ArenaClientFallback;
import ch.bfh.springerstifu.promoter.model.Party;

@FeignClient(value = "arena-service", fallback = ArenaClientFallback.class)
public interface ArenaClient {
	@PostMapping("/battle")
	String battle(@RequestBody List<Party> challenger);
	List<Party> battle(List<Party> challenger);
}
