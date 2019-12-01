package pl.konmarek.firstspringexample.controller;

import org.springframework.web.bind.annotation.*;
import pl.konmarek.firstspringexample.domain.Address;
import pl.konmarek.firstspringexample.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressRestController {

    private AddressService addressService;

    public AddressRestController(AddressService addressService) {
        this.addressService = addressService;
    }

    // /address/my-address
    @GetMapping("/my-address")
    public Address getMyAddress(){
        return new Address("Warszawa", "Modzelewskiego",
                "02-679");
    }
    // /address/save
    @GetMapping("/save")
    public Address sveNewAddress(@RequestParam("city") String city,
                                 @RequestParam("street")String street,
                                 @RequestParam("postalCode")String postalCode){

        Address toSave = new Address(city, street, postalCode);
        return addressService.saveNewAddress(toSave);
    }
}
