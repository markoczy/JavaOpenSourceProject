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
		return "<h2> For the Promoter it is a honor to pronounce the winner of todays battle: </h2>" + result;
	}

}
