package ch.bfh.springerstifu.camp.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import ch.bfh.springerstifu.camp.model.Party;
import ch.bfh.springerstifu.camp.service.PartyService;

@RestController
@RequestMapping("/parties")
public class PartyController {
    @Autowired
    PartyService partyService;

    @GetMapping("/create/{name}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Party createParty(@PathVariable String name) {
        return partyService.createParty(name);
    }
}