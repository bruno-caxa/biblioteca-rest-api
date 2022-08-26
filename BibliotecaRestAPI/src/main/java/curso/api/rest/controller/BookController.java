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

import curso.api.rest.model.Book;
import curso.api.rest.repository.BookRepository;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		bookRepository.deleteById(id);
		return "ok";
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		List<Book> books = bookRepository.findAll();
		return ResponseEntity.ok().body(books);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {
		Book book = bookRepository.findById(id).orElse(new Book());
		return ResponseEntity.ok().body(book);
	}
	
	@PostMapping
	public ResponseEntity<Book> insert(@RequestBody Book book) {
		Book bookAux = bookRepository.save(book);
		return ResponseEntity.ok().body(bookAux);
	}
}
