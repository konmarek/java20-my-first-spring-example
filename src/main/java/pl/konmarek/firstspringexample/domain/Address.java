package pl.konmarek.firstspringexample.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Name;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

//Krok 1. nadaj encje nad klasa
@Entity
public class Address {

    //krok 2- utworz klucz glowny

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String street;
    private String postalCode;

    //Krok 3. konstruktor bezargumentowy (krok 4 w addressRepository->)
    public Address() {
    }

    public Address(String city, String street, String postalCode) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    @JsonProperty("miasto")
    public String getCity() {
        return city;
    }

    @JsonProperty("ulica")
    public String getStreet() {
        return street;
    }

    @JsonProperty("kod pocztowy")
    public String getPostalCode() {
        return postalCode;
    }

    @Override
        public String toString() {
            return "Address{" +
                    "id=" + id +
                    ", city='" + city + '\'' +
                    ", street='" + street + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    '}';
        }

}
