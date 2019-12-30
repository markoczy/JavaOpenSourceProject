package ch.bfh.springerstifu.promoter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.bfh.springerstifu.promoter.service.PromoterService;

@RestController
@RequestMapping("promoter")
public class PromoterController {

	@Autowired
	private PromoterService promoterService;

	@GetMapping(value = "/promoteFight")
	public @ResponseBody String promoteFight() {
		String result = promoterService.promoteFight();
		return "The Promoter is proud to proclaim the following result of today's battle: " + result;
	}

}
