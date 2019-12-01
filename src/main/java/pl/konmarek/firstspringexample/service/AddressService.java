package pl.konmarek.firstspringexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.konmarek.firstspringexample.domain.Address;
import pl.konmarek.firstspringexample.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> allAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    public Address saveNewAddress(Address toSave){
        logger.info("address before saving: [{}]", toSave);
        toSave = addressRepository.save(toSave);
        logger.info("address before saving: [{}]", toSave);

        return toSave;
    }

}
