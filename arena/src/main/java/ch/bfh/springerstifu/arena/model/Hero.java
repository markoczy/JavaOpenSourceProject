package ch.bfh.springerstifu.arena.model;

public class Hero {
	private String name;
	private int atk;
	private int def;
	private double hp;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public boolean isAlive() {
		return hp > 0;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", atk=" + atk + ", def=" + def + ", hp=" + hp + "]";
	}

}
