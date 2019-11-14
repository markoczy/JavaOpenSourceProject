package ch.bfh.springerstifu.heroes.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hero {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")

    private String id;
    private String name;
    private int atk;
    private int def;
    private int hp;
    private Long atkQuery;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this. id = id;
    }

    public Long getHeroATKGreaterThan(){
        return atkQuery;
    }
    public void setHeroATKGreaterThan(Long atk){
        this.atkQuery = atk;
    }
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String toString() {
        return "{name: " + name + ", atk: " + atk + ", def: " + def + ", hp: " + hp + "}";
    }
}
