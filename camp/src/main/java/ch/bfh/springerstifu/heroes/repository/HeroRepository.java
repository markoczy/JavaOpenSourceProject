package ch.bfh.springerstifu.heroes.repository;

import ch.bfh.springerstifu.heroes.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, String> {
    Long countByAtkGreaterThan(Integer atk);
}
