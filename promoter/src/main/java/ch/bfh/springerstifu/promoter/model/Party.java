package ch.bfh.springerstifu.promoter.model;

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

}
