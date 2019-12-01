package pl.konmarek.firstspringexample.repository;

import org.springframework.data.repository.CrudRepository;
import pl.konmarek.firstspringexample.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
