package ch.bfh.springerstifu.promoter.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinServlet;

import ch.bfh.springerstifu.promoter.model.Hero;
import ch.bfh.springerstifu.promoter.model.Party;
import ch.bfh.springerstifu.promoter.service.PromoterService;

@Route(value = "promoter/promoteFight")
public class PromoterController extends VerticalLayout {

	private Grid<Hero> gridWinner, gridDead, gridLooser;

	@Autowired
	private PromoterService promoterService;

	public void init() {
		this.gridWinner = new Grid<>(Hero.class);
		this.gridDead = new Grid<>(Hero.class);
		this.gridLooser = new Grid<>(Hero.class);

		gridWinner.setHeightByRows(true);
		gridDead.setHeightByRows(true);
		gridLooser.setHeightByRows(true);

		gridWinner.setColumns("name", "hp", "atk", "def");
		gridDead.setColumns("name", "hp", "atk", "def");
		gridLooser.setColumns("name", "hp", "atk", "def");

		List<Party> parties = promoterService.promoteFight();

		Party winners = parties.stream().filter(p -> p.isWinner()).findAny().get();
		Party loosers = parties.stream().filter(p -> !p.isWinner()).findAny().get();

		List<Hero> heroesWinners = winners.getMembers().stream().filter(h -> h.isAlive()).collect(Collectors.toList());
		List<Hero> heroesDead = winners.getMembers().stream().filter(h -> !h.isAlive()).collect(Collectors.toList());
		List<Hero> heroesLoosers = loosers.getMembers();

		gridWinner.setItems(heroesWinners);
		gridDead.setItems(heroesDead);
		gridLooser.setItems(heroesLoosers);
		Label labelPromote = new Label(
				"As the humble promoter, it is a honor to pronounce the winner of todays battle after a very bloody fight between: "
						+ winners.getName() + " and " + loosers.getName());
		Label labelWinner = new Label(winners.getName());

		Label labelDead = new Label("Heroes of the winner party who has fought well but sadly has fallen:");

		Label labelLoosers = new Label("The brave fighters who did not make it: ");

		HorizontalLayout actions = new HorizontalLayout();
		add(actions, labelPromote, labelWinner, gridWinner, labelDead, gridDead, labelLoosers, gridLooser);

	}

	@Override
	protected void onAttach(AttachEvent attachEvent) {

		ServletContext servletContext = VaadinServlet.getCurrent().getServletContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getAutowireCapableBeanFactory()
				.autowireBean(this);

		init();
	}
}
