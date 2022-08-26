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

import curso.api.rest.model.Rental;
import curso.api.rest.repository.RentalRepository;

@RestController
@RequestMapping(value = "/rentals")
public class RentalController {

	@Autowired
	private RentalRepository rentalRepository;
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		rentalRepository.deleteById(id);
		return "ok";
	}
	
	@GetMapping
	public ResponseEntity<List<Rental>> findAll() {
		List<Rental> rentals = rentalRepository.findAll();
		return ResponseEntity.ok().body(rentals);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rental> findById(@PathVariable Long id) {
		Rental rental = rentalRepository.findById(id).orElse(new Rental());
		return ResponseEntity.ok().body(rental);
	}
	
	@PostMapping()
	public ResponseEntity<Rental> insert(@RequestBody Rental rental) {
		Rental rentalAux = rentalRepository.save(rental);
		return ResponseEntity.ok().body(rentalAux);
	}
	
}
