package curso.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.api.rest.model.Locator;

@Repository
public interface LocatorRepository extends JpaRepository<Locator, Long> {

}
