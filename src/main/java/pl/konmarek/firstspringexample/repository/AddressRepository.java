package pl.konmarek.firstspringexample.repository;

import org.springframework.data.repository.CrudRepository;
import pl.konmarek.firstspringexample.domain.Address;

//Krok 4 - rozszerz interfejs CrudRepository
//Krok 5 - pierwszy argument generyka - klasa do ktorej tworzymy repozytorium(tutaj Address)
//Krok 6 - podaj typ klucza glownego(tutaj Long)
public interface AddressRepository extends CrudRepository<Address, Long> {
}

