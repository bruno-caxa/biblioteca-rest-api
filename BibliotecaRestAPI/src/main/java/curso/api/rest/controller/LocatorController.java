package curso.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Locator;
import curso.api.rest.repository.LocatorRepository;

@RestController
@RequestMapping(value = "/locators")
public class LocatorController {

	@Autowired
	private LocatorRepository locatorRepository;
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		locatorRepository.deleteById(id);
		return "ok";
	}
	
	@GetMapping
	public ResponseEntity<List<Locator>> findAll() {
		List<Locator> locators = locatorRepository.findAll();
		return ResponseEntity.ok().body(locators);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Locator> findById(@PathVariable Long id) {
		Locator locator = locatorRepository.findById(id).orElse(new Locator());
		return ResponseEntity.ok().body(locator);
	}
	
	@PostMapping
	public ResponseEntity<Locator> insert(@RequestBody Locator locator) {
		Locator locatorAux = locatorRepository.save(locator);
		return ResponseEntity.ok().body(locatorAux);
	}
}
