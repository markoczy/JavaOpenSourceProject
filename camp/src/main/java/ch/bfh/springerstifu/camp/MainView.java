package ch.bfh.springerstifu.camp;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.springerstifu.camp.model.Hero;
import ch.bfh.springerstifu.camp.model.Party;
import ch.bfh.springerstifu.camp.repository.HeroRepository;
import ch.bfh.springerstifu.camp.service.PartyService;

@Route(value = "home")
public class MainView extends VerticalLayout {

	private final HeroRepository heroRepo;
	final Grid<Hero> grid;
	@Autowired
	private PartyService partyService;

	public MainView(HeroRepository heroRepo) {
		this.heroRepo = heroRepo;
		this.grid = new Grid<>(Hero.class);

		Label label = new Label("List of all Heroes and their party");
		HorizontalLayout actions = new HorizontalLayout();
		add(actions, label, grid);

		grid.setItems((Collection<Hero>) heroRepo.findAll());
		grid.setColumns("name", "atk", "def");
		grid.addColumn(x -> partyName(x)).setHeader("Party name");

	}

	private String partyName(Hero hero) {
		List<Party> parties = partyService.getParties();
		for (Party party : parties) {
			if (party.getMembers().contains(hero))
				return party.getName();
		}
		return "no Party";
	}
}
