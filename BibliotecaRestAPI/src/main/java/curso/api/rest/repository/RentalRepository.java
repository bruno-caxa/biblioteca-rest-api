package curso.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.api.rest.model.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

}
