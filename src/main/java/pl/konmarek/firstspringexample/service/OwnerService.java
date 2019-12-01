package pl.konmarek.firstspringexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.konmarek.firstspringexample.domain.Owner;
import pl.konmarek.firstspringexample.repository.OwnerRepository;

import java.util.List;

@Service
public class OwnerService {
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    private OwnerRepository ownerRepository;
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> allOwners(){
        List<Owner> result = (List<Owner>) ownerRepository.findAll();
        logger.info("results from Db: {[]}", result);
        return result;
    }

    public Owner saveOwner (Owner toSave){
        //przed zapisaniem
        logger.info("owner before save: [{}]", toSave);
        Owner saved = ownerRepository.save(toSave);
        logger.info("owner after save: [{}]", saved);

        return saved;
    }
}
