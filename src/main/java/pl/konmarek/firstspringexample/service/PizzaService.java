package pl.konmarek.firstspringexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.konmarek.firstspringexample.pizza.Pizza;
import pl.konmarek.firstspringexample.repository.PizzaRepo;

import java.util.Collections;
import java.util.List;

@Service
public class PizzaService {

    private static final Logger logger = LoggerFactory.getLogger(PizzaService.class);

    private PizzaRepo pizzaRepo;

    public PizzaService(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

   public List<Pizza> getAllPizzasInMenu(){

        logger.info("getAllPizzasInMenu()");

        return pizzaRepo.getAllPizzas();
    }

    public List<Pizza> getPizzasWithIngredients(List<String> ingredients){

        logger.info("getPizzasWithIngredients()");

        return Collections.emptyList();
        //pobral wszystkie pizze
        //wyfiltrowal i podal tylko z wymaganumi skladnikami
    }
}
