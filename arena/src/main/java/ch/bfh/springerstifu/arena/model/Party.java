package ch.bfh.springerstifu.arena.model;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class Party extends RepresentationModel {

	private String name;
	private List<Hero> members;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Hero> getMembers() {
		return members;
	}

	public void setMembers(List<Hero> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<h3>" + name + "</h3>");
		for (Hero hero : members) {
			if (hero.isAlive()) {
				sb.append("<br />" + hero);
			}
		}
		sb.append("<br />Heroes of the winner party who has fought well but sadly has fallen:");
		for (Hero hero : members) {
			if (!hero.isAlive()) {
				sb.append("<br />" + hero);
			}
		}
		return sb.toString();
	}

}
