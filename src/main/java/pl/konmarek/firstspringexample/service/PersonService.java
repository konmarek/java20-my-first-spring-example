package pl.konmarek.firstspringexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.konmarek.firstspringexample.domain.Person;
import pl.konmarek.firstspringexample.repository.PersonRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    private static final int MAX_SIZE_OF_PERSON_QUERY = 20;

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // for (Person p: personRepository.findAll())
    public List<Person> findAllPersons() {
        //max 20 osob

        List<Person> result = new ArrayList<>();

//        int counter = 0;
//        for (Person p: personRepository.findAll()){
//            if (counter < MAX_SIZE_OF_PERSON_QUERY){
//                counter++;
//                result.add(p);
//            }else{
//                break;
//            }
//        }

        Iterator<Person> personIterator = personRepository.findAll().iterator();
        while (personIterator.hasNext() && result.size() < MAX_SIZE_OF_PERSON_QUERY) {
            Person p = personIterator.next();
            result.add(p);

//            if (result.size() == MAX_SIZE_OF_PERSON_QUERY) {
//                break;
//            }
        }

        return result;
    }
}
