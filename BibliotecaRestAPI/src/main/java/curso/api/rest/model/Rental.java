package curso.api.rest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tb_rental")
public class Rental implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(optional = false)
	private Locator locator;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_book_rental", uniqueConstraints = @UniqueConstraint(columnNames = {"book_id"}),
			   joinColumns = @JoinColumn(name = "rental_id", referencedColumnName = "id", table = "rental"),
			   inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id", table = "book"))
	private List<Book> books = new ArrayList<>();
	
	public Rental() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Locator getLocator() {
		return locator;
	}

	public void setLocator(Locator locator) {
		this.locator = locator;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
