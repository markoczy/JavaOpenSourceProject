package ch.bfh.springerstifu.camp.repository;

import ch.bfh.springerstifu.camp.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, String> {
    Long countByAtkGreaterThan(Integer atk);
}
