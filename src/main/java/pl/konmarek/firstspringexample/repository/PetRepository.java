package pl.konmarek.firstspringexample.repository;

import org.springframework.data.repository.CrudRepository;
import pl.konmarek.firstspringexample.domain.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
