package pl.konmarek.firstspringexample.repository;

import org.springframework.data.repository.CrudRepository;
import pl.konmarek.firstspringexample.domain.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long > {

}
