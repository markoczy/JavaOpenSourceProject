package ch.bfh.springerstifu.arena.model;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class Party extends RepresentationModel<Party> {

	private String name;
	private List<Hero> members;
	private boolean isWinner;

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

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

}
