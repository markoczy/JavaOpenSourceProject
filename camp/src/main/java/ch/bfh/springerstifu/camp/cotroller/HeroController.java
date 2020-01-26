package ch.bfh.springerstifu.camp.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.bfh.springerstifu.camp.model.Hero;
import ch.bfh.springerstifu.camp.repository.HeroRepository;

@RestController
@RequestMapping("heroes")
public class HeroController {

	@Autowired
	private HeroRepository heroRepository;

	@GetMapping
	public @ResponseBody Iterable<Hero> list() {
		return heroRepository.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody Hero getById(@PathVariable String id) {
		return heroRepository.findById(id).get();
	}

	@GetMapping("/atkgreater/{atk}")
	public @ResponseBody long getById(@PathVariable Integer atk) {
		return heroRepository.countByAtkGreaterThan(atk);
	}

	@PostMapping
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Hero hero) {
		heroRepository.save(hero);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void delete(@RequestBody String id) {
		heroRepository.deleteById(id);
	}
}