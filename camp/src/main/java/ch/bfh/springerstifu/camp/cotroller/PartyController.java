package ch.bfh.springerstifu.camp.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import ch.bfh.springerstifu.camp.model.Hero;
import ch.bfh.springerstifu.camp.model.Party;
import ch.bfh.springerstifu.camp.service.PartyService;

@RestController
@RequestMapping("/parties")
public class PartyController {
    @Autowired
    PartyService partyService;

    @Autowired
    private RepositoryEntityLinks entityLinks;

    @GetMapping("/create/{name}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Party createParty(@PathVariable String name) {
        Party party = partyService.createParty(name);

        // HATEOAS w/o Spring Data Rest: Had to take example from prof..
        party.add(linkTo(methodOn(PartyController.class).createParty(name)).withSelfRel());
        for (int i = 0; i < party.getMembers().size(); i++) {
            party.add(
                    entityLinks.linkToItemResource(Hero.class, party.getMembers().get(i).getId()).withRel("hero" + i));
        }
        return party;

    }
}