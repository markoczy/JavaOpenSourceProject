package ch.bfh.springerstifu.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.bfh.springerstifu.camp.model.Hero;

@Repository
public interface HeroRepository extends CrudRepository<Hero, String> {
	long countByAtkGreaterThan(Integer atk);

}
